

import java.io.UnsupportedEncodingException;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */

public class mdencode {
    public mdencode() {
    }

    public String testDigest(String myinfo) {
        byte[] digesta = null;
        try {
            java.security.MessageDigest alga = java.security.MessageDigest.
                    getInstance("MD5");
            alga.update(myinfo.getBytes());
            digesta = alga.digest();

        } catch (java.security.NoSuchAlgorithmException ex) {
            System.out.println("非法摘要算法");
        }
        return this.byte2hex(digesta);
    }

    public String testDigest(String myinfo, String charset) {
        byte[] digesta = null;
        try {
            java.security.MessageDigest alga = java.security.MessageDigest.
                    getInstance("MD5");
            try {
                alga.update(myinfo.getBytes(charset));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            digesta = alga.digest();

        } catch (java.security.NoSuchAlgorithmException ex) {
            System.out.println("非法摘要算法");
        }
        return this.byte2hex(digesta);
    }

    public String byte2hex(byte[] b) { //二行制转字符串
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
            if (n < b.length - 1) {
                hs = hs;
            }
        }
        return hs;
    }

    public static void main(String[] args) {
        mdencode md = new mdencode();
        String psw = "A97154019b2159304c1fdae0a41d3d5ecaf06c820141216A971540000017  ";
        System.out.println(md.testDigest(psw));

 //       System.out.println(md.testDigest("A085664c625b7861a92c7971cd2029c2fd3c4a6cc3229b009a933f0a6d931918a5e051fe6283db0ced7503632fdc61172382a5"));
    }

}