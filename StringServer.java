import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {

    @Override
    public String handleRequest(URI url) {

       if (url.getPath().equals("/"))
       return String.format("concatenate strings");
   else if (url.getPath().equals("/add-message"))  {
            String Query = url.getQuery();
            return String.format(Query);
   }
   return String.format("404 not found");
       
    }

    public class StringServer {
        public static void main(String[] args) throws IOException {
            if (args.length == 0) {
                System.out.println("Missing port number! Try any number between 1024 to 49151");
                return;
            }
            int port = Integer.parseInt(args[0]);
    
            Server.start(port, new Handler());
        }
    }
}