public class WorldGen{
    public void generate(Collidable map[][]){
        for(int r=0; r<map.length; r++){
            for(int c=0; c<map[0].length; c++){
                //grass
                double grassChance = Math.random();
                if(r == 21)
                    map[r][c] = new Grass(c*20-7000,r*20,20,20);
                if(r == 22 && grassChance < .9)
                    map[r][c] = new Grass(c*20-7000,r*20,20,20);
                if(r == 23 && grassChance < .8)
                    map[r][c] = new Grass(c*20-7000,r*20,20,20);
                if(r == 24 && grassChance < .7)
                    map[r][c] = new Grass(c*20-7000,r*20,20,20);
                if(r == 25 && grassChance < .6)
                    map[r][c] = new Grass(c*20-7000,r*20,20,20);
                if(r == 26 && grassChance < .5)
                    map[r][c] = new Grass(c*20-7000,r*20,20,20);
                if(r == 27 && grassChance < .4)
                    map[r][c] = new Grass(c*20-7000,r*20,20,20);
                if(r == 28 && grassChance < .3)
                    map[r][c] = new Grass(c*20-7000,r*20,20,20);
                if(r == 29 && grassChance < .2)
                    map[r][c] = new Grass(c*20-7000,r*20,20,20);
                if(r == 30 && grassChance < .1)
                    map[r][c] = new Grass(c*20-7000,r*20,20,20);
                //dirt
                if(r >= 21 && map[r][c] == null)
                    map[r][c] = new Dirt(c*20-7000,r*20,20,20);
                //rock
                double rockChance = Math.random();
                double g = 0;
                if(r > 30) g = .1;
                if(r > 60) g = .2;
                if(r > 90) g = .3;
                if(r > 120) g = .4;
                if(r > 180) g = .5;
                if(r > 250) g = .6;
                if(r > 300) g = .7;
                if(r > 400) g = .8;
                if(r > 500) g = .9;
                if(r > 600) g = 1;
                if(rockChance < g)
                    map[r][c] = new Rock(c*20-7000,r*20,20,20);
                //border
                if(r > 700 || r == 0 || c < 25 || c > 675)
                    map[r][c] = new Border(c*20-7000,r*20,20,20);
            }
        }
        map[21][365] = new Border(365*20-7000,21*20,20,20);
        map[21][366] = new Border(366*20-7000,21*20,20,20);
        map[21][367] = new Border(367*20-7000,21*20,20,20);
        //caves
        //original 100
        for(int i=0; i<100; i++){
            int r = (int)(Math.random()*680)+20;
            int c = (int)(Math.random()*600)+50;
            if(map[r][c] != null && map[r][c].getId() != 2)
                map[r][c] = null;
            //original 1500
            for(int j=0; j<1500; j++){
                double k = Math.random();
                //up
                if(k >= 0 && k < .25 && r-1 > -1)
                    r--;
                //right
                if(k >= .25 && k < .5 && c+1 < 735)
                    c++;
                //down
                if(k >= .5 && k < .75 && r+1 < 735)
                    r++;
                //left
                if(k >= .75 && k < 1 && c-1 > -1)
                    c--;
                if(map[r][c] != null && map[r][c].getId() != 2)
                    map[r][c] = null;
            }
        }
        //coal
        //original 300
        for(int i=0; i<300; i++){
            int r = (int)(Math.random()*735);
            int c = (int)(Math.random()*735);
            if(map[r][c] != null && map[r][c].getId() != 2)
                map[r][c] = new Coal(c*20-7000,r*20,20,20);
            //original 10
            for(int j=0; j<10; j++){
                double k = Math.random();
                //up
                if(k >= 0 && k < .25 && r-1 > -1)
                    r--;
                //right
                if(k >= .25 && k < .5 && c+1 < 735)
                    c++;
                //down
                if(k >= .5 && k < .75 && r+1 < 735)
                    r++;
                //left
                if(k >= .75 && k < 1 && c-1 > -1)
                    c--;
                if(map[r][c] != null && map[r][c].getId() != 2)
                    map[r][c] = new Coal(c*20-7000,r*20,20,20);
            }
        }
        //amethyst
        //original 200
        for(int i=0; i<200; i++){
            int r = (int)(Math.random()*535)+200;
            int c = (int)(Math.random()*735);
            if(map[r][c] != null && map[r][c].getId() != 2)
                map[r][c] = new Amethyst(c*20-7000,r*20,20,20);
            //original 8
            for(int j=0; j<8; j++){
                double k = Math.random();
                //up
                if(k >= 0 && k < .25 && r-1 > -1)
                    r--;
                //right
                if(k >= .25 && k < .5 && c+1 < 735)
                    c++;
                //down
                if(k >= .5 && k < .75 && r+1 < 735)
                    r++;
                //left
                if(k >= .75 && k < 1 && c-1 > -1)
                    c--;
                if(map[r][c] != null && map[r][c].getId() != 2)
                    map[r][c] = new Amethyst(c*20-7000,r*20,20,20);
            }
        }
        //diamond
        //original 100
        for(int i=0; i<100; i++){
            int r = (int)(Math.random()*335)+400;
            int c = (int)(Math.random()*735);
            if(map[r][c] != null && map[r][c].getId() != 2)
                map[r][c] = new Diamond(c*20-7000,r*20,20,20);
            //original 6
            for(int j=0; j<6; j++){
                double k = Math.random();
                //up
                if(k >= 0 && k < .25 && r-1 > -1)
                    r--;
                //right
                if(k >= .25 && k < .5 && c+1 < 735)
                    c++;
                //down
                if(k >= .5 && k < .75 && r+1 < 735)
                    r++;
                //left
                if(k >= .75 && k < 1 && c-1 > -1)
                    c--;
                if(map[r][c] != null && map[r][c].getId() != 2)
                    map[r][c] = new Diamond(c*20-7000,r*20,20,20);
            }
        }
        //ruby
        //original 100
        for(int i=0; i<100; i++){
            int r = (int)(Math.random()*135)+600;
            int c = (int)(Math.random()*735);
            if(map[r][c] != null && map[r][c].getId() != 2)
                map[r][c] = new Ruby(c*20-7000,r*20,20,20);
            //original 6
            for(int j=0; j<6; j++){
                double k = Math.random();
                //up
                if(k >= 0 && k < .25 && r-1 > -1)
                    r--;
                //right
                if(k >= .25 && k < .5 && c+1 < 735)
                    c++;
                //down
                if(k >= .5 && k < .75 && r+1 < 735)
                    r++;
                //left
                if(k >= .75 && k < 1 && c-1 > -1)
                    c--;
                if(map[r][c] != null && map[r][c].getId() != 2)
                    map[r][c] = new Ruby(c*20-7000,r*20,20,20);
            }
        }
        //emerald
        //original 25
        for(int i=0; i<25; i++){
            int r = (int)(Math.random()*85)+650;
            int c = (int)(Math.random()*735);
            if(map[r][c] != null && map[r][c].getId() != 2)
                map[r][c] = new Emerald(c*20-7000,r*20,20,20);
            //original 20
            for(int j=0; j<20; j++){
                double k = Math.random();
                //up
                if(k >= 0 && k < .25 && r-1 > -1)
                    r--;
                //right
                if(k >= .25 && k < .5 && c+1 < 735)
                    c++;
                //down
                if(k >= .5 && k < .75 && r+1 < 735)
                    r++;
                //left
                if(k >= .75 && k < 1 && c-1 > -1)
                    c--;
                if(map[r][c] != null && map[r][c].getId() != 2)
                    map[r][c] = new Emerald(c*20-7000,r*20,20,20);
            }
        }
        //diorite
        for(int i=0; i<200; i++){
            int r = (int)(Math.random()*685)+50;
            int c = (int)(Math.random()*735);
            if(map[r][c] != null && map[r][c].getId() != 2)
                map[r][c] = new Diorite(c*20-7000,r*20,20,20);
            for(int j=0; j<50; j++){
                double k = Math.random();
                //up
                if(k >= 0 && k < .25 && r-1 > -1)
                    r--;
                //right
                if(k >= .25 && k < .5 && c+1 < 735)
                    c++;
                //down
                if(k >= .5 && k < .75 && r+1 < 735)
                    r++;
                //left
                if(k >= .75 && k < 1 && c-1 > -1)
                    c--;
                if(map[r][c] != null && map[r][c].getId() != 2)
                    map[r][c] = new Diorite(c*20-7000,r*20,20,20);
            }
        }
    }
}