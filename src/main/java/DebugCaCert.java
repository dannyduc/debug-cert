import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DebugCaCert {

    public static void main(String[] args) throws Exception {
//        URL url = new URL("https://google.com");
//        URL url = new URL("https://apps-stable.ingenuity.com/ingsso");
//        URL url = new URL("https://apps-stable2.ingenuity.com/ingsso");
//        URL url = new URL("https://confluence.informatics.qiagen.com");
        if (args.length != 1) {
            System.out.println("Usage: DebugCaCert <urlToDebug>");
            System.exit(1);
        }

        URL url = new URL(args[0]);
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        byte[] buffer = new byte[8048];

        int read = is.read(buffer);
        while (read != -1) {
            String response = new String(buffer, 0, read);
//            System.out.print(response);
            read = is.read(buffer);
        }
        is.close();
    }
}
