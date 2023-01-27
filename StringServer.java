import java.io.IOException;
import java.net.URI;
class Handler implements URLHandler {
    String holder = "";
    
    @Override
    public String handleRequest(URI url) {
        if (url.getPath().equals("/"))
            return String.format("Concecate String version 1");
        else if (url.getPath().contains("/add-message")) {
            String[] element = url.getQuery().split("s=");// first element is blank
            holder += element[1] + "\r";
            return String.format(holder);
        }
        return String.format("Try Again!");
    }
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }
        int port = Integer.parseInt(args[0]);
        Server.start(port, new Handler());
    }
}


/**
         * http://localhost:4533/add-message?s=Hello java StringServer 4500
         *** For path , any query part does not count, include all slashes behind
         *** path = /add (slash before)
         *** All string after ? , including
         **/
