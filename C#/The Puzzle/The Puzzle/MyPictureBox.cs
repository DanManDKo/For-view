using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace The_Puzzle
{
    class MyPictureBox:PictureBox
    {
        int index = 0;
        int imageIndex = 0;

        public bool isMatch() {
            return (index == imageIndex);
        }

        public int Index
        {
            get
            {
                return index;
            }

            set
            {
                index = value;
            }
        }

        public int ImageIndex
        {
            get
            {
                return imageIndex;
            }

            set
            {
                imageIndex = value;
            }
        }
    }
}
