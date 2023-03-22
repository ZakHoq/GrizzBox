import java.util.Scanner;
/*
    This class should be called as soon as the "submit" button is pressed
    Response will get the players response and store it in an array
 */
public class Response {

    private String response = "";
    private String[] responseArray;
    private final int responseArraySize = 6;  //the max amount of players for our game is 6, each response will be stored at an index
    private int responseIndex = 0;
    private int submission = 0;
    /*
     idea: maybe do a submission count instead? when the count==#ofPlayers, then we are all set and the timer can stop
     increment submission count every time a response is stored
     might be easier to actually keep track
     have it work with whatever keeps track of the timer
     */

    Scanner scanner = new Scanner(System.in);

    public Response(){
        responseArray = new String[responseArraySize];
    }

    public String getResponse() {

        while(scanner.hasNextLine()) {
            response += scanner.nextLine();     //in case their response is multiple lines
        }

        submission++;     //if we go with other idea for submission

        return response;
    }

    public void storeResponse(String response) {
        /*
            we might have to send the array as a parameter?
         */
        if (responseIndex < responseArraySize) {
            responseArray[responseIndex] = response;
            responseIndex++;
        }

        System.out.println(responseArray[0]);
    }

    //Needs to be called at the end of each round
    public void clearResponse() {
        responseIndex = 0;
        while (responseIndex < responseArraySize) {
            responseArray[responseIndex] = "";
            responseIndex++;
        }
    }


}
