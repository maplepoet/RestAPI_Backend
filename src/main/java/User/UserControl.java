package User;

import com.google.gson.Gson;

import static spark.Spark.get;
import static spark.Spark.port;

public class UserControl {
    public static void main(String[] args) {
        // Set the port your API will run on
        port(4567);

        // Create an instance of the Gson library for JSON serialization
        Gson gson = new Gson();

        // Define a simple route to get user data
        get("/users", (request, response) -> {
            response.type("application/json");

            // Add CORS headers
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            response.header("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, Authorization");
            response.header("Access-Control-Allow-Credentials", "true");


            // Create a sample list of users
            User[] users = {
                    new User(1, "Alice"),
                    new User(2, "Bob"),
                    new User(3, "Charlie")
            };

            // Serialize the users to JSON
            return gson.toJson(users);
        });
    }
}
