package cu.etecsa.tm.ecommerce.qHBfDCWv13G;

import android.content.Context;
import android.util.Log;
import cu.etecsa.tm.ecommerce.R;

/* JADX INFO: loaded from: classes.dex */
public class IGxV3uh9sw {
    private static Context context;
    private static boolean isDebug = true;
    private static final IGxV3uh9sw ourInstance = new IGxV3uh9sw();

    public static IGxV3uh9sw getInstance(Context aContext) {
        context = aContext;
        return ourInstance;
    }

    public String getMessage(int code) {
        switch (code) {
            case 401:
                return "No autorizado.";
            case 402:
                String mensaje = context.getString(R.string.default_error_msg);
                return mensaje;
            case 403:
                String mensaje2 = context.getString(R.string.default_error_msg);
                return mensaje2;
            case 404:
                String mensaje3 = context.getString(R.string.default_error_msg);
                return mensaje3;
            case 405:
                String mensaje4 = context.getString(R.string.default_error_msg);
                return mensaje4;
            case 422:
                String mensaje5 = context.getString(R.string.default_error_msg);
                return mensaje5;
            case 500:
                String mensaje6 = context.getString(R.string.default_error_msg);
                return mensaje6;
            default:
                String mensaje7 = context.getString(R.string.default_error_msg);
                return mensaje7;
        }
    }

    public String getMessage(int code, String headMessage, String message) {
        Log.e("BULEVAR-ERROR", headMessage + ": " + message);
        switch (code) {
            case 401:
                return "No autorizado.";
            case 402:
                String mensaje = context.getString(R.string.default_error_msg);
                return mensaje;
            case 403:
                String mensaje2 = context.getString(R.string.default_error_msg);
                return mensaje2;
            case 404:
                String mensaje3 = context.getString(R.string.default_error_msg);
                return mensaje3;
            case 405:
                String mensaje4 = context.getString(R.string.default_error_msg);
                return mensaje4;
            case 422:
                String mensaje5 = context.getString(R.string.default_error_msg);
                return mensaje5;
            case 500:
                String mensaje6 = context.getString(R.string.default_error_msg);
                return mensaje6;
            default:
                String mensaje7 = context.getString(R.string.default_error_msg);
                return mensaje7;
        }
    }

    public void WriteLog(int code, String headMessage, String message) {
        Log.e("BULEVAR-ERROR", headMessage + ": CODE [" + String.valueOf(code) + "]" + message);
    }

    /* JADX INFO: renamed from: cu.etecsa.tm.ecommerce.qHBfDCWv13G.IGxV3uh9sw$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$cu$etecsa$tm$ecommerce$qHBfDCWv13G$UZsizlaDNk;

        static {
            int[] iArr = new int[UZsizlaDNk.values().length];
            $SwitchMap$cu$etecsa$tm$ecommerce$qHBfDCWv13G$UZsizlaDNk = iArr;
            try {
                iArr[UZsizlaDNk.LISTAR_USERS_GET.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$qHBfDCWv13G$UZsizlaDNk[UZsizlaDNk.LISTAR_USERS_SET.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$qHBfDCWv13G$UZsizlaDNk[UZsizlaDNk.LISTAR_CUENTAS_GET.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$qHBfDCWv13G$UZsizlaDNk[UZsizlaDNk.LOGIN_SIMPLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$qHBfDCWv13G$UZsizlaDNk[UZsizlaDNk.PAGO_DINAMICO_POST.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$qHBfDCWv13G$UZsizlaDNk[UZsizlaDNk.LISTAR_NEGOCIOS_GET.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$qHBfDCWv13G$UZsizlaDNk[UZsizlaDNk.DEVOLVER_PAGO.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$cu$etecsa$tm$ecommerce$qHBfDCWv13G$UZsizlaDNk[UZsizlaDNk.GET_PERMISOS.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:119:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:138:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:157:0x0233  */
    /* JADX WARN: Code duplicated, block: B:17:0x0039  */
    /* JADX WARN: Code duplicated, block: B:38:0x0088  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:77:0x0111  */
    /* JADX WARN: Code duplicated, block: B:99:0x0162  */
    public String getErrorMessage(UZsizlaDNk tipo, String code) {
        switch (AnonymousClass1.$SwitchMap$cu$etecsa$tm$ecommerce$qHBfDCWv13G$UZsizlaDNk[tipo.ordinal()]) {
            case 1:
                switch (code) {
                    case "1":
                        String mensaje = context.getString(R.string.tx_no_item_mostrar);
                        return mensaje;
                    case "100":
                        String mensaje2 = context.getString(R.string.error_msg_no_permiso);
                        return mensaje2;
                    case "401":
                        return "No autorizado.";
                    default:
                        String mensaje3 = context.getString(R.string.default_error_msg);
                        return mensaje3;
                }
            case 2:
                switch (code.hashCode()) {
                    case 49:
                        if (!code.equals("1")) {
                        }
                        break;
                    case 48625:
                        if (!code.equals("100")) {
                        }
                        break;
                    case 51509:
                        if (!code.equals("401")) {
                        }
                        break;
                    default:
                        break;
                }
                /*  JADX ERROR: Method code generation error
                    java.lang.NullPointerException: Switch insn not found in header
                    	at java.base/java.util.Objects.requireNonNull(Objects.java:246)
                    	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:246)
                    	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:267)
                    	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                    	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                    	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                    	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                    */
                /*
                    Method dump skipped, instruction units count: 824
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: cu.etecsa.tm.ecommerce.qHBfDCWv13G.IGxV3uh9sw.getErrorMessage(cu.etecsa.tm.ecommerce.qHBfDCWv13G.UZsizlaDNk, java.lang.String):java.lang.String");
            }
        }
