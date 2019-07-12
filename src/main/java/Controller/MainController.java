package Controller;

import Constant.MainConstant;
import Service.MainService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainController {

    public static void main(String[] args){

        if(args.length == 0){ // Interactive command prompt's part

            String userInput;
            Scanner sn = new Scanner(System.in);

            while(true){
                userInput = sn.next();
                MainController.takeActionByGoal(userInput);
            }

        }else if(args.length == 1){ // File as a parameter's part

            BufferedReader br = null;

            try{
                File f = new File(args[0]);
                br = new BufferedReader(new FileReader(f));
                String currentLine;

                while((currentLine = br.readLine()) != null){
                    MainController.takeActionByGoal(currentLine);
                }

            }catch(IOException e){
                e.printStackTrace();

            }finally{
                try{
                    if(br != null) br.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }

        }else{
            System.err.print("Invalid arguments count:" + args.length);
        }
    }

    private static void takeActionByGoal(String command){

        String[] segments = command.split(MainConstant.BLANK);
        String goal = segments[0];
        switch(goal){
            case "create_parking_lot":
                MainService.createParkingLot(segments[1]);
                break;

            case "parking":
                MainService.parkCar(segments[1], segments[2]);
                break;

            case "leave":
                MainService .leaveCar(segments[1]);
                break;

            case "status":
                MainService.checkStatus();
                break;

            case "registration_numbers_for_cars_with_colour":
                MainService.getRegistrationNumbersByColor(segments[1]);
                break;

            case "slot_numbers_for_cars_with_colour":
                MainService.getSlotNumbersByColor(segments[1]);
                break;

            case "slot_number_for_registration_number":
                MainService.getSlotNumberByRegistrationNumber(segments[1]);
                break;

            default:
                System.out.println("Invalid command:" + segments[0]);
        }
    }
}
