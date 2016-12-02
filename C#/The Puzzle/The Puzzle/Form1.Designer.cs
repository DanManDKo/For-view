namespace The_Puzzle
{
    partial class Form1
    {
        /// <summary>
        /// Обязательная переменная конструктора.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Освободить все используемые ресурсы.
        /// </summary>
        /// <param name="disposing">истинно, если управляемый ресурс должен быть удален; иначе ложно.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Код, автоматически созданный конструктором форм Windows

        /// <summary>
        /// Требуемый метод для поддержки конструктора — не изменяйте 
        /// содержимое этого метода с помощью редактора кода.
        /// </summary>
        private void InitializeComponent()
        {
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.buttonImageBrowse = new System.Windows.Forms.Button();
            this.textBoxImagePath = new System.Windows.Forms.TextBox();
            this.groupboxPuzzle = new System.Windows.Forms.GroupBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.buttonLevel4 = new System.Windows.Forms.Button();
            this.buttonLevel3 = new System.Windows.Forms.Button();
            this.buttonLevel2 = new System.Windows.Forms.Button();
            this.buttonLevel1 = new System.Windows.Forms.Button();
            this.groupBoxStatus = new System.Windows.Forms.GroupBox();
            this.labelStatus = new System.Windows.Forms.Label();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.groupBoxStatus.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.buttonImageBrowse);
            this.groupBox1.Controls.Add(this.textBoxImagePath);
            this.groupBox1.Location = new System.Drawing.Point(0, 0);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(768, 56);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Choose image";
            // 
            // buttonImageBrowse
            // 
            this.buttonImageBrowse.Location = new System.Drawing.Point(475, 17);
            this.buttonImageBrowse.Name = "buttonImageBrowse";
            this.buttonImageBrowse.Size = new System.Drawing.Size(92, 23);
            this.buttonImageBrowse.TabIndex = 1;
            this.buttonImageBrowse.Text = "Choose Image";
            this.buttonImageBrowse.UseVisualStyleBackColor = true;
            this.buttonImageBrowse.Click += new System.EventHandler(this.buttonImageBrowse_Click);
            // 
            // textBoxImagePath
            // 
            this.textBoxImagePath.Location = new System.Drawing.Point(6, 19);
            this.textBoxImagePath.Name = "textBoxImagePath";
            this.textBoxImagePath.Size = new System.Drawing.Size(444, 20);
            this.textBoxImagePath.TabIndex = 0;
            // 
            // groupboxPuzzle
            // 
            this.groupboxPuzzle.Location = new System.Drawing.Point(6, 62);
            this.groupboxPuzzle.Name = "groupboxPuzzle";
            this.groupboxPuzzle.Size = new System.Drawing.Size(444, 444);
            this.groupboxPuzzle.TabIndex = 1;
            this.groupboxPuzzle.TabStop = false;
            this.groupboxPuzzle.Text = "Puzzle";
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.buttonLevel4);
            this.groupBox2.Controls.Add(this.buttonLevel3);
            this.groupBox2.Controls.Add(this.buttonLevel2);
            this.groupBox2.Controls.Add(this.buttonLevel1);
            this.groupBox2.Location = new System.Drawing.Point(475, 62);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(192, 192);
            this.groupBox2.TabIndex = 0;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Play Mode";
            // 
            // buttonLevel4
            // 
            this.buttonLevel4.Location = new System.Drawing.Point(7, 149);
            this.buttonLevel4.Name = "buttonLevel4";
            this.buttonLevel4.Size = new System.Drawing.Size(179, 23);
            this.buttonLevel4.TabIndex = 3;
            this.buttonLevel4.Text = "Level 4";
            this.buttonLevel4.UseVisualStyleBackColor = true;
            this.buttonLevel4.Click += new System.EventHandler(this.buttonLevel4_Click);
            // 
            // buttonLevel3
            // 
            this.buttonLevel3.Location = new System.Drawing.Point(7, 109);
            this.buttonLevel3.Name = "buttonLevel3";
            this.buttonLevel3.Size = new System.Drawing.Size(179, 23);
            this.buttonLevel3.TabIndex = 2;
            this.buttonLevel3.Text = "Level 3";
            this.buttonLevel3.UseVisualStyleBackColor = true;
            this.buttonLevel3.Click += new System.EventHandler(this.buttonLevel3_Click);
            // 
            // buttonLevel2
            // 
            this.buttonLevel2.Location = new System.Drawing.Point(7, 68);
            this.buttonLevel2.Name = "buttonLevel2";
            this.buttonLevel2.Size = new System.Drawing.Size(179, 23);
            this.buttonLevel2.TabIndex = 1;
            this.buttonLevel2.Text = "Level 2";
            this.buttonLevel2.UseVisualStyleBackColor = true;
            this.buttonLevel2.Click += new System.EventHandler(this.buttonLevel2_Click);
            // 
            // buttonLevel1
            // 
            this.buttonLevel1.Location = new System.Drawing.Point(7, 28);
            this.buttonLevel1.Name = "buttonLevel1";
            this.buttonLevel1.Size = new System.Drawing.Size(179, 23);
            this.buttonLevel1.TabIndex = 0;
            this.buttonLevel1.Text = "Level 1";
            this.buttonLevel1.UseVisualStyleBackColor = true;
            this.buttonLevel1.Click += new System.EventHandler(this.buttonLevel1_Click);
            // 
            // groupBoxStatus
            // 
            this.groupBoxStatus.Controls.Add(this.labelStatus);
            this.groupBoxStatus.Location = new System.Drawing.Point(475, 280);
            this.groupBoxStatus.Name = "groupBoxStatus";
            this.groupBoxStatus.Size = new System.Drawing.Size(200, 186);
            this.groupBoxStatus.TabIndex = 2;
            this.groupBoxStatus.TabStop = false;
            this.groupBoxStatus.Text = "Status";
            // 
            // labelStatus
            // 
            this.labelStatus.AutoSize = true;
            this.labelStatus.Location = new System.Drawing.Point(18, 16);
            this.labelStatus.Name = "labelStatus";
            this.labelStatus.Size = new System.Drawing.Size(24, 13);
            this.labelStatus.TabIndex = 0;
            this.labelStatus.Text = "Idle";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(678, 512);
            this.Controls.Add(this.groupBoxStatus);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupboxPuzzle);
            this.Controls.Add(this.groupBox1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "The Puzzle";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBoxStatus.ResumeLayout(false);
            this.groupBoxStatus.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Button buttonImageBrowse;
        private System.Windows.Forms.TextBox textBoxImagePath;
        private System.Windows.Forms.GroupBox groupboxPuzzle;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Button buttonLevel4;
        private System.Windows.Forms.Button buttonLevel3;
        private System.Windows.Forms.Button buttonLevel2;
        private System.Windows.Forms.Button buttonLevel1;
        private System.Windows.Forms.GroupBox groupBoxStatus;
        private System.Windows.Forms.Label labelStatus;
    }
}

