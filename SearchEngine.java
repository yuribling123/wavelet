import java.io.IOException;
import java.net.URI;

//implement the web server that tracks list of string
// a path for adding a new string to the list
//a path for querying the list of strings and returning a list of all strings that have a given substring
class Handler implements URLHandler {

    @Override
    public String handleRequest(URI url) {
        // TODO Auto-generated method stub
        if (url.getPath().equals("/"))
            return String.format("Enter a Fruit");
        else if (url.getPath().equals("/search") ||
                url.getPath().equals("/add")) {
            // loop
            String query = url.getQuery();
            return String.format(check(query));
        }
        return String.format("505 not found");
    }

    public String check(String query) {
        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) == "apple".charAt(i)) {
                return "apple";
            }
        }
        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) == "orange".charAt(i)) {
                return "orange";
            }
        }
        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) == "pineapple".charAt(i)) {
                return "pineapple";
            }
        }
        return "no";
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
