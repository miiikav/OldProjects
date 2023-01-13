#include "mainwindow.hh"
#include "ui_mainwindow.h"

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


void MainWindow::on_countButton_clicked()
{
    double bmi=(weight/(height*height))*10000;
    ui->resultLabel->setNum(bmi);
    if(bmi<18.5){
        ui->infoTextBrowser->clear();
        ui->infoTextBrowser->append("You are underweight.");
    }
    else if(bmi<25){
        ui->infoTextBrowser->clear();
        ui->infoTextBrowser->append("Your weight is normal.");
    }
    else{
        ui->infoTextBrowser->clear();
        ui->infoTextBrowser->append("You are overweight.");
    }
}

void MainWindow::on_weightLineEdit_editingFinished()
{
    weight=ui->weightLineEdit->text().toInt();
}

void MainWindow::on_heightLineEdit_editingFinished()
{
    height=ui->heightLineEdit->text().toInt();
}

