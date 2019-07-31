package Controller;

import Constant.MainConstant;
import Module.ParkingLot;
import Service.MainService;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class MainController {

    public static void main(String[] args) throws Exception {

        if(args.length == 0){ // Interactive command prompt's part

            String userInput;
            Scanner scanner = new Scanner(System.in);

            while(true){
                userInput = scanner.next();
                String result = MainController.takeActionByGoal(userInput);
                System.out.println(result);
            }

        }else if(args.length == 1){ // File as a parameter's part

            BufferedReader br = null;
            BufferedWriter bw = null;

            try{
                File f = new File(args[0]);
                br = new BufferedReader(new FileReader(f));
                File outputFile = new File("file_outputs.txt");
                bw = new BufferedWriter(new FileWriter(outputFile));
                String currentLine;

                while((currentLine = br.readLine()) != null){
                    String result = MainController.takeActionByGoal(currentLine);
                    bw.write(result);
                    bw.write(System.getProperty("line.separator"));
                }

            }catch(IOException e){
                e.printStackTrace();

            }finally{
                try{
                    if(br != null) br.close();
                    if(bw != null) bw.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }

        }else{
            System.err.print("Invalid arguments count:" + args.length);
        }
    }

    private static String takeActionByGoal(String command) throws Exception{

        String[] segments = command.split(MainConstant.BLANK);
        String goal = segments[0];
        switch(goal){
            case "create_parking_lot":
                ParkingLot parkingLot = MainService.createParkingLot(segments[1]);
                return "Created a parking lot with " + parkingLot.getSlots().size() + " slots";

            case "parking":
                Integer number = MainService.parkCar(segments[1], segments[2]);
                return number != null ? "Allocated slot number: " + number.intValue() : "Sorry, parking lot is full";

            case "leave":
                MainService.leaveCar(segments[1]);
                return "Slot number " + segments[1] + " is free";

            case "status":
                String status = MainService.checkStatus();
                return status;

            case "registration_numbers_for_cars_with_colour":
                String[] registrationNumbers = MainService.getRegistrationNumbersByColor(segments[1]);
                String regNums = Arrays.toString(registrationNumbers);
                return regNums.substring(1, regNums.length() -1);

            case "slot_numbers_for_cars_with_colour":
                Integer[] slotNumbers = MainService.getSlotNumbersByColor(segments[1]);
                String slotNums = Arrays.toString(slotNumbers);
                return slotNums.substring(1, slotNums.length() -1);

            case "slot_number_for_registration_number":
                Integer slotNumber = MainService.getSlotNumberByRegistrationNumber(segments[1]);
                return slotNumber != null ? String.valueOf(slotNumber) : "Not found";

            default:
                System.out.println("Invalid command:" + segments[0]);
        }
    }
}
