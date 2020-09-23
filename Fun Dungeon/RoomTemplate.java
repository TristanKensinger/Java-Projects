import java.util.*;

public class RoomTemplate{
    //room layouts
    public void room1(ArrayList<Obstacle> list){
        //concrete
        for(int r = 0; r < 15; r++){
            for(int c = 0; c < 15; c++){
                if((r == 0 || c == 0 || r == 14 || c  == 14) && !(r == 0 && c == 7) && !(r == 7 && c == 0) && !(r == 14 && c == 7) && !(r == 7 && c == 14))
                    list.add(new Wall(-1, -1, r, c, 40, 40));
            }
        }
        //variation
        list.add(new Door(-1,-1,0,7,40,40));
        list.add(new Door(-1,-1,7,0,40,40));
        list.add(new Door(-1,-1,14,7,40,40));
        list.add(new Door(-1,-1,7,14,40,40));
    }

    public void room2(ArrayList<Obstacle> list){
        //concrete
        for(int r = 0; r < 15; r++){
            for(int c = 0; c < 15; c++){
                if((r == 0 || c == 0 || r == 14 || c  == 14) && !(r == 0 && c == 7) && !(r == 7 && c == 0) && !(r == 14 && c == 7) && !(r == 7 && c == 14))
                    list.add(new Wall(-1, -1, r, c, 40, 40));
                else if(r%2 == 0 && c%2 == 0)
                    list.add(new Wall(-1, -1, r, c, 40, 40));
            }
        }
        //variation
        list.add(new Door(-1,-1,0,7,40,40));
        list.add(new Door(-1,-1,7,0,40,40));
        list.add(new Door(-1,-1,14,7,40,40));
        list.add(new Door(-1,-1,7,14,40,40));
    }

    public void room3(ArrayList<Obstacle> list){
        //concrete
        for(int r = 0; r < 15; r++){
            for(int c = 0; c < 15; c++){
                if((r == 0 || c == 0 || r == 14 || c  == 14) && !(r == 0 && c == 7) && !(r == 7 && c == 0) && !(r == 14 && c == 7) && !(r == 7 && c == 14))
                    list.add(new Wall(-1, -1, r, c, 40, 40));
                else if((c == 4 && (r > 1 && r < 13)) || (c == 10 && (r > 1 && r < 13)))
                    list.add(new Wall(-1, -1, r, c, 40, 40));
            }
        }
        //variation
        list.add(new Door(-1,-1,0,7,40,40));
        list.add(new Door(-1,-1,7,0,40,40));
        list.add(new Door(-1,-1,14,7,40,40));
        list.add(new Door(-1,-1,7,14,40,40));
    }

    public void room4(ArrayList<Obstacle> list){
        //concrete
        for(int r = 0; r < 15; r++){
            for(int c = 0; c < 15; c++){
                if((r == 0 || c == 0 || r == 14 || c  == 14) && !(r == 0 && c == 7) && !(r == 7 && c == 0) && !(r == 14 && c == 7) && !(r == 7 && c == 14))
                    list.add(new Wall(-1, -1, r, c, 40, 40));
                else if((r == 4 && (c > 1 && c < 13)) || (r == 10 && (c > 1 && c < 13)))
                    list.add(new Wall(-1, -1, r, c, 40, 40));
            }
        }
        //variation
        list.add(new Door(-1,-1,0,7,40,40));
        list.add(new Door(-1,-1,7,0,40,40));
        list.add(new Door(-1,-1,14,7,40,40));
        list.add(new Door(-1,-1,7,14,40,40));
    }

    public void room5(ArrayList<Obstacle> list){
        //concrete
        for(int r = 0; r < 15; r++){
            for(int c = 0; c < 15; c++){
                if((r == 0 || c == 0 || r == 14 || c  == 14) && !(r == 0 && c == 7) && !(r == 7 && c == 0) && !(r == 14 && c == 7) && !(r == 7 && c == 14))
                    list.add(new Wall(-1, -1, r, c, 40, 40));
            }
        }
        //variation
        list.add(new Door(-1,-1,0,7,40,40));
        list.add(new Door(-1,-1,7,0,40,40));
        list.add(new Door(-1,-1,14,7,40,40));
        list.add(new Door(-1,-1,7,14,40,40));
        //gavin's code
        list.add(new Wall(-1, -1, 3, 2, 40, 40));//         grid[3][2] = 1;
        list.add(new Wall(-1, -1, 2, 3, 40, 40));//         grid[2][3] = 1;
        list.add(new Wall(-1, -1, 11, 2, 40, 40));//         grid[11][2] = 1;
        list.add(new Wall(-1, -1, 12, 3, 40, 40));//         grid[12][3] = 1;
        list.add(new Wall(-1, -1, 2, 11, 40, 40));//         grid[2][11] = 1;
        list.add(new Wall(-1, -1, 3, 12, 40, 40));//         grid[3][12] = 1;
        list.add(new Wall(-1, -1, 12, 11, 40, 40));//         grid[12][11] = 1;
        list.add(new Wall(-1, -1, 11, 12, 40, 40));//         grid[11][12] = 1;
        list.add(new Wall(-1, -1, 6, 5, 40, 40));//         grid[6][5] = 1;
        list.add(new Wall(-1, -1, 6, 6, 40, 40));//         grid[6][6] = 1;
        list.add(new Wall(-1, -1, 7, 5, 40, 40));//         grid[7][5] = 1;
        list.add(new Wall(-1, -1, 8, 5, 40, 40));//         grid[8][5] = 1;
        list.add(new Wall(-1, -1, 9, 5, 40, 40));//         grid[9][5] = 1;
        list.add(new Wall(-1, -1, 9, 6, 40, 40));//         grid[9][6] = 1;
        list.add(new Wall(-1, -1, 6, 8, 40, 40));//         grid[6][8] = 1;
        list.add(new Wall(-1, -1, 6, 9, 40, 40));//         grid[6][9] = 1;
        list.add(new Wall(-1, -1, 7, 9, 40, 40));//         grid[7][9] = 1;
        list.add(new Wall(-1, -1, 8, 9, 40, 40));//         grid[8][9] = 1;
        list.add(new Wall(-1, -1, 9, 9, 40, 40));//         grid[9][9] = 1;
        list.add(new Wall(-1, -1, 9, 8, 40, 40));//         grid[9][8] = 1;
    }

    public void room6(ArrayList<Obstacle> list){
        //concrete
        for(int r = 0; r < 15; r++){
            for(int c = 0; c < 15; c++){
                if((r == 0 || c == 0 || r == 14 || c  == 14) && !(r == 0 && c == 7) && !(r == 7 && c == 0) && !(r == 14 && c == 7) && !(r == 7 && c == 14))
                    list.add(new Wall(-1, -1, r, c, 40, 40));
            }
        }
        //variation
        list.add(new Door(-1,-1,0,7,40,40));
        list.add(new Door(-1,-1,7,0,40,40));
        list.add(new Door(-1,-1,14,7,40,40));
        list.add(new Door(-1,-1,7,14,40,40));
        //gavin's code
        list.add(new Wall(-1, -1, 4, 3, 40, 40));//         grid[4][3] = 1;
        list.add(new Wall(-1, -1, 4, 4, 40, 40));//         grid[4][4] = 1;
        list.add(new Wall(-1, -1, 4, 5, 40, 40));//         grid[4][5] = 1;
        list.add(new Wall(-1, -1, 3, 4, 40, 40));//         grid[3][4] = 1;
        list.add(new Wall(-1, -1, 5, 4, 40, 40));//         grid[5][4] = 1;
        list.add(new Wall(-1, -1, 10, 3, 40, 40));//         grid[10][3] = 1;
        list.add(new Wall(-1, -1, 10, 4, 40, 40));//         grid[10][4] = 1;
        list.add(new Wall(-1, -1, 10, 5, 40, 40));//         grid[10][5] = 1;
        list.add(new Wall(-1, -1, 9, 4, 40, 40));//         grid[9][4] = 1;
        list.add(new Wall(-1, -1, 11, 4, 40, 40));//         grid[11][4] = 1;
        list.add(new Wall(-1, -1, 10, 9, 40, 40));//         grid[10][9] = 1;
        list.add(new Wall(-1, -1, 10, 10, 40, 40));//         grid[10][10] = 1;
        list.add(new Wall(-1, -1, 10, 11, 40, 40));//         grid[10][11] = 1;
        list.add(new Wall(-1, -1, 9, 10, 40, 40));//         grid[9][10] = 1;
        list.add(new Wall(-1, -1, 11, 10, 40, 40));//         grid[11][10] = 1;
        list.add(new Wall(-1, -1, 4, 9, 40, 40));//         grid[4][9] = 1;
        list.add(new Wall(-1, -1, 4, 10, 40, 40));//         grid[4][10] = 1;
        list.add(new Wall(-1, -1, 4, 11, 40, 40));//         grid[4][11] = 1;
        list.add(new Wall(-1, -1, 3, 10, 40, 40));//         grid[3][10] = 1;
        list.add(new Wall(-1, -1, 5, 10, 40, 40));//         grid[5][10] = 1;
    }

    public void room7(ArrayList<Obstacle> list){
        //concrete
        for(int r = 0; r < 15; r++){
            for(int c = 0; c < 15; c++){
                if((r == 0 || c == 0 || r == 14 || c  == 14) && !(r == 0 && c == 7) && !(r == 7 && c == 0) && !(r == 14 && c == 7) && !(r == 7 && c == 14))
                    list.add(new Wall(-1, -1, r, c, 40, 40));
            }
        }
        //variation
        list.add(new Door(-1,-1,0,7,40,40));
        list.add(new Door(-1,-1,7,0,40,40));
        list.add(new Door(-1,-1,14,7,40,40));
        list.add(new Door(-1,-1,7,14,40,40));
        //gavin's code
        list.add(new Wall(-1, -1, 4, 3, 40, 40));//         grid[4][3] = 1;
        list.add(new Wall(-1, -1, 4, 4, 40, 40));//         grid[4][4] = 1;
        list.add(new Wall(-1, -1, 4, 5, 40, 40));//         grid[4][5] = 1;
        list.add(new Wall(-1, -1, 9, 5, 40, 40));//         grid[9][5] = 1;
        list.add(new Wall(-1, -1, 9, 6, 40, 40));//         grid[9][6] = 1;
        list.add(new Wall(-1, -1, 9, 7, 40, 40));//         grid[9][7] = 1;
        list.add(new Wall(-1, -1, 9, 8, 40, 40));//         grid[9][8] = 1;
        list.add(new Wall(-1, -1, 2, 11, 40, 40));//         grid[2][11] = 1;
        list.add(new Wall(-1, -1, 2, 12, 40, 40));//         grid[2][12] = 1;
        list.add(new Wall(-1, -1, 12, 11, 40, 40));//         grid[12][11] = 1;
        list.add(new Wall(-1, -1, 12, 12, 40, 40));//         grid[12][12] = 1;
        list.add(new Wall(-1, -1, 12, 2, 40, 40));//         grid[12][2] = 1;
        list.add(new Wall(-1, -1, 12, 3, 40, 40));//         grid[12][3] = 1;
        list.add(new Wall(-1, -1, 12, 4, 40, 40));//         grid[12][4] = 1;
        list.add(new Wall(-1, -1, 6, 9, 40, 40));//         grid[6][9] = 1;
        list.add(new Wall(-1, -1, 6, 10, 40, 40));//         grid[6][10] = 1;
        list.add(new Wall(-1, -1, 6, 11, 40, 40));//         grid[6][11] = 1;
    }
}