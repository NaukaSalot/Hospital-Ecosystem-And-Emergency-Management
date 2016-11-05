/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.RoomDetails;

import java.util.ArrayList;

/**
 *
 * @author Nauka Salot
 */
public class RoomDirectory {

    private ArrayList<RoomDetails> roomList;

    public RoomDirectory() {
        roomList = new ArrayList<>();
    }

    public ArrayList<RoomDetails> getRoomList() {
        return roomList;
    }

    public void setRoomList(ArrayList<RoomDetails> roomList) {
        this.roomList = roomList;
    }

    public RoomDetails addRoom() {
        RoomDetails roomdetails = new RoomDetails();
        roomList.add(roomdetails);

        return roomdetails;
    }
}
