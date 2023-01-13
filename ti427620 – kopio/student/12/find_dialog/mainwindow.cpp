#include "mainwindow.hh"
#include "ui_mainwindow.h"

#include <iostream>
#include <sstream>
#include <fstream>
#include <string>

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);
}

MainWindow::~MainWindow()
{
    delete ui;
}



void MainWindow::on_findPushButton_clicked()
{
    std::string cmd_string;
    bool notFound = true;
    // File query
    std::string fileName = ui->fileLineEdit->text().toStdString();
    std::string whatName = ui->keyLineEdit->text().toStdString();
    std::istringstream str(fileName);
    std::getline(str, cmd_string);

    // Query result must be transformed from std::string to c_string so it can
    //  be passed to ifstream's constructor.
    std::ifstream datafile(cmd_string.c_str());
    if(not datafile)
    {
        ui->textBrowser->append("File not found");
    }
    else{
        ui->textBrowser->append("File found");
        // Read the entire file into memory
        std::string s;
        std::string t;
        if(ui->matchCheckBox->isChecked()==true){
            while (getline( datafile, t )){
                std::transform(t.begin(), t.end(), t.begin(),
                    [](unsigned char c){ return std::tolower(c); });
                s += t + '\n';
            }
            datafile.close();
            //to lowercase
            std::transform(whatName.begin(), whatName.end(), whatName.begin(),
                [](unsigned char c){ return std::tolower(c); });
            for (std::string::size_type index = s.find( whatName, 0 );
                 index != std::string::npos;
                 index = s.find( whatName, index + 1 )){
                ui->textBrowser->clear();
                ui->textBrowser->append("Word found");
                notFound=false;
                break;
            }
            if(notFound==true){
                ui->textBrowser->clear();
                ui->textBrowser->append("Word not found");
            }

        }
        else if(ui->matchCheckBox->isChecked()==false){
            while (getline( datafile, t )){
                s += t + '\n';
            }
            datafile.close();
            for (std::string::size_type index = s.find( whatName, 0 );
                 index != std::string::npos;
                 index = s.find( whatName, index + 1 )){
                ui->textBrowser->clear();
                ui->textBrowser->append("Word found");
                notFound=false;
                break;
            }
            if(notFound==true){
                ui->textBrowser->clear();
                ui->textBrowser->append("Word not found");
            }
        };
    }

}
