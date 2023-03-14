package View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import View.Tile;
import controller.Controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * main class to handle the mechanism behind how each tile si diplayed which is put into a 2d array
 * @author 
 *
 */
public class TileManager {
    GamePanel gp;
    protected Tile[] tile;
    protected int mapTileNum[][];
    
    
  
    public Tile[] getTile() {
		return tile;
	}

	public void setTile(Tile[] tile) {
		this.tile = tile;
	}

	public int[][] getMapTileNum() {
		return mapTileNum;
	}

	public void setMapTileNum(int[][] mapTileNum) {
		this.mapTileNum = mapTileNum;
	}

	/**
     * constructor which initializes the variables
     * @param gp
     */
    public TileManager(GamePanel gp){
       
    	this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.MAXSCREENCOLLUMN][gp.MAXSCREENROW];

        getTileImage();
        loadMap();
    }

    /**
     * getter to set up the array that hoilds the different tiles to be rendered
     */
    public void getTileImage() {
        try {
        	File ground1 = new File("bin/images/map/ground.png");
            File hill1 = new File("bin/images/map/hill1.png");
            File hill2 = new File("bin/images/map/hill2.png");
            File hill3 = new File("bin/images/map/hill3.png");
            File hill4 = new File("bin/images/map/hill4.png");
            File hill5 = new File("bin/images/map/hill5.png");
            File hill6 = new File("bin/images/map/hill6.png");
            File sky1 = new File("bin/images/map/sky.png");

             BufferedImage ground_1 = ImageIO.read(ground1);
            BufferedImage hill_1 = ImageIO.read(hill1);
             BufferedImage hill_2 = ImageIO.read(hill2);
             BufferedImage hill_3= ImageIO.read(hill3);
             BufferedImage hill_4= ImageIO.read(hill4);
            BufferedImage hill_5= ImageIO.read(hill5);
            BufferedImage hill_6= ImageIO.read(hill6);
             BufferedImage sky_1= ImageIO.read(sky1);

            tile[0] = new Tile();
            tile[0].image = ground_1;
            tile[0].collision = true;

            tile[1] = new Tile();
            tile[1].image =sky_1;

            tile[2] = new Tile();
            tile[2].image =hill_1;
            tile[3] = new Tile();
            tile[3].image =hill_2;
            tile[4] = new Tile();
            tile[4].image = hill_3;
            tile[5] =new Tile();
            tile[5].image = hill_4;
            tile[6] = new Tile();
            tile[6].image =hill_5;
            tile[7] = new Tile();
            tile[7].image = hill_6;

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * this is the main method that renders the entire screen loops through an array and sets tiles based on the determined layout
     */
    public void loadMap(){
        try {
        	File map = new File("bin/images/map/maps/map01.txt");
        	
           // InputStream is = getClass().getResourceAsStream("../player/maps/map01.txt");
        	InputStream is = new FileInputStream(map);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col=0;
            int row=0;
            while(col < gp.MAXSCREENCOLLUMN && row < gp.MAXSCREENROW){
                String line = br.readLine();
                while(col < gp.MAXSCREENCOLLUMN){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.MAXSCREENCOLLUMN){
                    col = 0;
                    row++;
                }
            }
            br.close();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * method for drawing the tiles using the graphics class
     * @param g2
     */
    public void draw(Graphics2D g2){
        

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < gp.MAXSCREENCOLLUMN && row < gp.MAXSCREENROW){

            int tileNum = mapTileNum[col][row];
            
            g2.drawImage(tile[tileNum].image, x, y, gp.TILESIZE, gp.TILESIZE, null);
            col++;
            x += gp.TILESIZE;

            if (col == gp.MAXSCREENCOLLUMN){
                col = 0;
                x = 0;
                row++;
                y += gp.TILESIZE;
            }
        }

    }
    
}
