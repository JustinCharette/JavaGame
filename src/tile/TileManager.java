package tile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import Main.GamePanel;
import java.awt.Graphics2D;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.MAXSCREENCOLLUMN][gp.MAXSCREENROW];

        getTileImage();
        loadMap();
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("../player/tiles/ground.png"));
            tile[0].collision = true;

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("../player/tiles/sky.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("../player/tiles/hill1.png"));
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("../player/tiles/hill2.png"));
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("../player/tiles/hill3.png"));
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("../player/tiles/hill4.png"));
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("../player/tiles/hill5.png"));
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("../player/tiles/hill6.png"));
            

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadMap(){
        try {
            InputStream is = getClass().getResourceAsStream("../player/maps/map01.txt");
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
