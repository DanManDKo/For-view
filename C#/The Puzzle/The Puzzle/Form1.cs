using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace The_Puzzle
{
    public partial class Form1 : Form
    {
   

        public Form1()
        {
            InitializeComponent();
            
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            
        }


        private  OpenFileDialog openFileDialog = null;
        private Image image;
        private PictureBox pictureBoxWhole = null;
        private MyPictureBox firstBox = null;
        private MyPictureBox secondBox = null;
        private PictureBox[] pictureBoxes = null;
        private Image[] images;
        private String gameStarus="stoped";
        int currentLevel = 0;
      


        private void buttonImageBrowse_Click(object sender, EventArgs e)
        {
            if (openFileDialog == null)
                openFileDialog = new OpenFileDialog();
            if(openFileDialog.ShowDialog()==DialogResult.OK){
                textBoxImagePath.Text = openFileDialog.FileName;
                image = CreateBitmapImage(Image.FromFile(openFileDialog.FileName));
                if (pictureBoxWhole == null) {
                    pictureBoxWhole = new PictureBox();
                    pictureBoxWhole.Width = groupboxPuzzle.Width;
                    pictureBoxWhole.Height = groupboxPuzzle.Height;
                    groupboxPuzzle.Controls.Add(pictureBoxWhole);

                }
                pictureBoxWhole.Image = image;
            }

        }

        private void CreateBitmapImage(Image image, Image[] images, int index, int numRow, int numCol, int unitX, int unitY)
        {
            images[index] = new Bitmap(unitX, unitY);
            Graphics graphics = Graphics.FromImage(images[index]);
            graphics.Clear(Color.White);
            graphics.DrawImage(image, 
                new Rectangle(0, 0, unitX, unitY), 
                new Rectangle(unitX * (index % numCol), unitY * (index / numCol), unitX, unitY),
                GraphicsUnit.Pixel);
            graphics.Flush();
        }

        private void shuffle(ref int[] array) {
            Random random = new Random();
            int n = array.Length;
            while (n > 1) {
                int k = random.Next(n);
                n--;
                int temp = array[n];
                array[n] = array[k];
                array[k] = temp;
            }
        }

        private Bitmap CreateBitmapImage(Image image)
        {
            Bitmap bitmapImage = new Bitmap(groupboxPuzzle.Width, groupboxPuzzle.Height);
            Graphics graphics = Graphics.FromImage(bitmapImage);
            graphics.Clear(Color.White);
            graphics.DrawImage(image, new Rectangle(0, 0, groupboxPuzzle.Width, groupboxPuzzle.Height));
            graphics.Flush();

            return bitmapImage;
        }


        public bool gameCheck()
        {
            if (image == null)
            {
                MessageBox.Show("You have first to choose a picture!", "Error", MessageBoxButtons.OK);
                return false;
            }
         
            return true;

        }

        void NewGameInit()
        {
            image = CreateBitmapImage(Image.FromFile(openFileDialog.FileName));
            if (pictureBoxWhole == null)
            {
                pictureBoxWhole = new PictureBox();
                pictureBoxWhole.Width = groupboxPuzzle.Width;
                pictureBoxWhole.Height = groupboxPuzzle.Height;
                groupboxPuzzle.Controls.Add(pictureBoxWhole);

            }
            pictureBoxWhole.Image = image;

            if (pictureBoxes != null)
            {
                foreach (var pict in pictureBoxes) pict.Dispose();
                pictureBoxes = null;
            }
                

        }

        const string OPEN_LEVEL_MESSAGE = "Level {0} is opened";
        void StartLevel(int level)
        {
            if (!gameCheck())
                return;
            NewGameInit();
            currentLevel = Convert.ToInt32(Math.Pow(level+1, 2));
            labelStatus.Text = String.Format(OPEN_LEVEL_MESSAGE, level);
            gameStarus = "started";
            PlayLevel();
        }

        private void buttonLevel1_Click(object sender, EventArgs e)
        {
            StartLevel(1);
        }

        

        private void buttonLevel2_Click(object sender, EventArgs e)
        {
            StartLevel(2);
        }


        private void buttonLevel3_Click(object sender, EventArgs e)
        {
            StartLevel(3);           
        }


        private void buttonLevel4_Click(object sender, EventArgs e)
        {
            StartLevel(4);          
        }

        private void PlayLevel()
        {
            if (pictureBoxWhole != null)
            {
                groupboxPuzzle.Controls.Remove(pictureBoxWhole);
                pictureBoxWhole.Dispose();
                pictureBoxWhole = null;
            }
            if (pictureBoxes == null)
            {
                images = new Image[currentLevel];
                pictureBoxes = new PictureBox[currentLevel];


            }
            int numRow = (int)Math.Sqrt(currentLevel);
            int numCol = numRow;
            int unitX = groupboxPuzzle.Width / numRow;
            int unitY = groupboxPuzzle.Height / numCol;
            int[] indice = new int[currentLevel];
            for (int i = 0; i < currentLevel; i++)
            {
                indice[i] = i;
                if (pictureBoxes[i] == null)
                {
                    pictureBoxes[i] = new MyPictureBox();
                    pictureBoxes[i].Click += new EventHandler(OnPuzzleClick);
                    pictureBoxes[i].BorderStyle = BorderStyle.Fixed3D;
                }
                pictureBoxes[i].Width = unitX;
                pictureBoxes[i].Height = unitY;

                ((MyPictureBox)pictureBoxes[i]).Index = i;

                CreateBitmapImage(image, images, i, numRow, numCol, unitX, unitY);
                pictureBoxes[i].Location = new Point(unitX * (i % numCol), unitY * (i / numCol));
                if (!groupboxPuzzle.Controls.Contains(pictureBoxes[i]))
                    groupboxPuzzle.Controls.Add(pictureBoxes[i]);

            }
            shuffle(ref indice);
            for (int i = 0; i < currentLevel; i++)
            {
                pictureBoxes[i].Image = images[indice[i]];
                ((MyPictureBox)pictureBoxes[i]).ImageIndex = indice[i];
            }
        }



        public void OnPuzzleClick(object sender, EventArgs e)
        {
            if (firstBox == null)
            {
                firstBox = (MyPictureBox)sender;
                firstBox.BorderStyle = BorderStyle.FixedSingle;

            }
            else if (secondBox == null)
            {
                secondBox = (MyPictureBox)sender;
                firstBox.BorderStyle = BorderStyle.Fixed3D;
                secondBox.BorderStyle = BorderStyle.FixedSingle;
                SwitchImage(firstBox, secondBox);
                firstBox = null;
                secondBox = null;
            }
        
        }

        public bool isSuccessful() {
            for (int i = 0; i < currentLevel; i++)
                if (((MyPictureBox)pictureBoxes[i]).ImageIndex != ((MyPictureBox)pictureBoxes[i]).Index)
                    return false;
            gameStarus = "stoped";
            return true;
        }

        private void SwitchImage(MyPictureBox box1, MyPictureBox box2) {
            int tmp = box2.ImageIndex;
            box2.Image = images[box1.ImageIndex];
            box2.ImageIndex = box1.ImageIndex;
            box1.Image = images[tmp];
            box1.ImageIndex = tmp;
            if (isSuccessful())
            {
                labelStatus.Text = "Well Done, Amigo! =o)";
                NewGameInit();
            }
                
        }

        
      
    }
}
