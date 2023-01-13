#include "mainwindow.hh"
#include "ui_mainwindow.h"
#include <QTimer>

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    timer = new QTimer(this);
    connect(this->timer,&QTimer::timeout,this,&MainWindow::updateTimer);
    timer->setInterval(1000);

    QPalette palMin = palette();
    palMin.setColor(QPalette::Window, Qt::blue);
    ui->lcdNumberMin->setAutoFillBackground(true);
    ui->lcdNumberMin->setPalette(palMin);
    ui->lcdNumberMin->show();

    QPalette palSec = palette();
    palSec.setColor(QPalette::Window, Qt::green);
    ui->lcdNumberSec->setAutoFillBackground(true);
    ui->lcdNumberSec->setPalette(palSec);
    ui->lcdNumberSec->show();
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::on_startButton_clicked()
{


        timer->start();
}

void MainWindow::on_stopButton_clicked()
{
        timer->stop();

}

void MainWindow::on_resetButton_clicked()
{
    timer->stop();
    sec=0;
    min=0;
    ui->lcdNumberSec->display(0);
    ui->lcdNumberMin->display(0);

}

void MainWindow::updateTimer()
{
    sec++;
    if(sec>=59){
        sec=0;
        min++;
    }
    ui->lcdNumberMin->display(min);
    ui->lcdNumberSec->display(sec);


}
