# Makefile — Transfermóvil Reverse Engineering Toolchain
#
# Targets:
#   make decompile APK=path/to.apk   Decompile APK into src/, smali/, app/
#   make verify APK=path/to.apk      Verify APK identity (SHA-256, package, version)
#   make stats                        Show mapping progress (mapped vs total classes)
#   make search Q="pattern"           Search decompiled Java source for a pattern
#   make search-smali Q="pattern"     Search smali disassembly for a pattern
#   make search-all Q="pattern"       Search both Java and smali
#   make clean-src                    Remove all decompiled source (src/, smali/)
#   make help                         Show this help
#
# Prerequisites:
#   jadx, apktool, aapt/aapt2 (Android SDK), jq, shasum
#
# Examples:
#   make decompile APK=.workspace/bin/cu.etecsa.cubacel.tr.tm-v162.apk
#   make verify APK=.workspace/bin/cu.etecsa.cubacel.tr.tm-v162.apk
#   make stats
#   make search Q="ACCESS_TOKEN"

.PHONY: help decompile verify stats search search-smali search-all clean-src

# Default APK path
APK ?= .workspace/bin/cu.etecsa.cubacel.tr.tm-v162.apk

help: ## Show available targets
	@echo "Transfermóvil RE Toolchain"
	@echo ""
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | \
		awk 'BEGIN {FS = ":.*?## "}; {printf "  \033[36m%-18s\033[0m %s\n", $$1, $$2}'
	@echo ""
	@echo "Variables:"
	@echo "  APK=<path>   Target APK file (default: $(APK))"
	@echo "  Q=<pattern>  Search pattern for grep"

decompile: ## Decompile APK into src/ (JADX), smali/ (Apktool), app/ (resources)
	@bash scripts/decompile.sh "$(APK)"

verify: ## Verify APK identity — SHA-256, package, version, SDK levels
	@bash scripts/verify-apk.sh "$(APK)"

stats: ## Show mapping progress — mapped vs total classes, clean class count
	@bash scripts/mapping-stats.sh

search: ## Search decompiled Java source (Q="pattern")
	@bash scripts/search-strings.sh "$(Q)" --java

search-smali: ## Search smali disassembly (Q="pattern")
	@bash scripts/search-strings.sh "$(Q)" --smali

search-all: ## Search both Java and smali (Q="pattern")
	@bash scripts/search-strings.sh "$(Q)" --both

clean-src: ## Remove decompiled source (src/ and smali/) — keeps app/ clean source
	@echo "This will delete src/ and smali/ directories."
	@read -p "Continue? [y/N] " confirm && [ "$$confirm" = "y" ] || exit 1
	rm -rf src/ smali/
	@echo "Removed src/ and smali/"
