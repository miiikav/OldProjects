#include "mainwindow.hh"
#include "ui_mainwindow.h"

#include <QKeyEvent>
#include <QDebug>
#include <QPixmap>
#include <vector>
#include <algorithm>

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    // We need a graphics scene in which to draw rectangles
    scene_ = new QGraphicsScene(this);

    // The width of the graphicsView is BORDER_RIGHT added by 2,
    // since the borders take one pixel on each side
    // (1 on the left, and 1 on the right).
    // Similarly, the height of the graphicsView is BORDER_DOWN added by 2.
    ui->graphicsView->setGeometry(LEFT_MARGIN, TOP_MARGIN,
                                  BORDER_RIGHT + 2, BORDER_DOWN + 2);
    ui->graphicsView->setScene(scene_);

    // The width of the scene_ is BORDER_RIGHT decreased by 1 and
    // the height of it is BORDER_DOWN decreased by 1, because
    // each square of a fruit is considered to be inside the sceneRect,
    // if its upper left corner is inside the sceneRect.
    scene_->setSceneRect(0, 0, BORDER_RIGHT - 1, BORDER_DOWN - 1);

    int seed = time(0); // You can change seed value for testing purposes
    randomEng_.seed(seed);
    distr_ = std::uniform_int_distribution<int>(0, NUMBER_OF_FRUITS - 1);
    distr_(randomEng_); // Wiping out the first random number (which is almost always 0)
    init_titles();

    for (int i = 0; i < (ROWS*COLUMNS); i++) {
        store_fruit();
        //draw_fruit();
    }
    // More code perhaps needed

}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::mousePressEvent(QMouseEvent *click)
{
    unsigned long long_j=selected_j;
    QPixmap pix(SQUARE_SIDE,SQUARE_SIDE);
    pix.fill(Qt::white);
    QPainter painter(&pix);
    QPen pen1;
    painter.setPen(pen1);
    pen1.setWidth(3);
    QPoint pos = mapToGlobal(QPoint(0, 0));
    pos = click->globalPos();
    //bool prevents user from selecting multiple fruits
    //bool selected=false;
    if(selected==true){
        //QGraphicsRectItem* item_template;

        if(fruit_grid.at(selected_i).at(selected_j)->contains(click->localPos())){
            selected=false;
            pen1.setColor(Qt::white);

            fruit_grid.at(selected_i).at(selected_j)->setPen(pen1);
            //fruit_grid.at(selected_i).at(selected_j)->setFlag((QGraphicsItem::ItemIsSelectable));
        }
        else if(!fruit_grid.at(selected_i+1).empty()
                && fruit_grid.at(selected_i+1).at(selected_j)->contains(click->localPos())
                && fruit_grid.at(selected_i+1).at(selected_j)->brush()!=Qt::white){
            qDebug()<<"selected_i-1"<<selected_i-1;;
            selected=false;
            pen1.setColor(Qt::white);
            fruit_grid.at(selected_i).at(selected_j)->setPen(pen1);
            //fruit_grid.at(selected_i).at(selected_j)->setFlag((QGraphicsItem::ItemIsSelectable));
            //std::iter_swap(fruit_grid.at(selected_i).at(selected_j),fruit_grid.at(selected_i+1).at(selected_j));
            //item_template=fruit_grid.at(selected_i+1).at(selected_j);
            //fruit_grid.at(selected_i+1).at(selected_j)=fruit_grid.at(selected_i).at(selected_j);
            //fruit_grid.at(selected_i).at(selected_j)=item_template;
            painter.setBrush(fruit_grid.at(selected_i).at(selected_j)->brush());
            fruit_grid.at(selected_i).at(selected_j)->setBrush(fruit_grid.at(selected_i+1).at(selected_j)->brush());
            fruit_grid.at(selected_i+1).at(selected_j)->setBrush(painter.brush());
            //remove_fruit();

        }
        else if(!fruit_grid.at(selected_i-1).empty()
                && fruit_grid.at(selected_i-1).at(selected_j)->contains(click->localPos())
                && fruit_grid.at(selected_i-1).at(selected_j)->brush()!=Qt::white){
            qDebug()<<"selected_i+1"<<selected_i+1;;
            selected=false;
            pen1.setColor(Qt::white);
            fruit_grid.at(selected_i).at(selected_j)->setPen(pen1);
            fruit_grid.at(selected_i).at(selected_j)->setFlag((QGraphicsItem::ItemIsSelectable));
            //std::iter_swap(fruit_grid.at(selected_i).at(selected_j),fruit_grid.at(selected_i-1).at(selected_j));
            //item_template=fruit_grid.at(selected_i-1).at(selected_j);
            //fruit_grid.at(selected_i-1).at(selected_j)=fruit_grid.at(selected_i).at(selected_j);
            //fruit_grid.at(selected_i).at(selected_j)=item_template;
            painter.setBrush(fruit_grid.at(selected_i).at(selected_j)->brush());
            fruit_grid.at(selected_i).at(selected_j)->setBrush(fruit_grid.at(selected_i-1).at(selected_j)->brush());
            fruit_grid.at(selected_i-1).at(selected_j)->setBrush(painter.brush());
            //remove_fruit();
        }

        else if(fruit_grid.at(selected_i).size()>long_j
                &&fruit_grid.at(selected_i).at(selected_j+1)->contains(click->localPos())
                && fruit_grid.at(selected_i).at(selected_j+1)->brush()!=Qt::white){
            qDebug()<<"selected_j+1"<<selected_j+1;;
            selected=false;
            pen1.setColor(Qt::white);
            fruit_grid.at(selected_i).at(selected_j)->setPen(pen1);
            //fruit_grid.at(selected_i).at(selected_j)->setFlag((QGraphicsItem::ItemIsSelectable));
            //std::iter_swap(fruit_grid.at(selected_i).at(selected_j),fruit_grid.at(selected_i).at(selected_j+1));
            //item_template=fruit_grid.at(selected_i).at(selected_j+1);
            //fruit_grid.at(selected_i).at(selected_j+1)=fruit_grid.at(selected_i).at(selected_j);
            //fruit_grid.at(selected_i).at(selected_j)=item_template;
            painter.setBrush(fruit_grid.at(selected_i).at(selected_j)->brush());
            fruit_grid.at(selected_i).at(selected_j)->setBrush(fruit_grid.at(selected_i).at(selected_j+1)->brush());
            fruit_grid.at(selected_i).at(selected_j+1)->setBrush(painter.brush());
            //remove_fruit();
        }
        else if(selected_j!=0
                && fruit_grid.at(selected_i).at(selected_j-1)->contains(click->localPos())
                && fruit_grid.at(selected_i).at(selected_j-1)->brush()!=Qt::white){
            selected=false;
            qDebug()<<"selected_j-1"<<selected_j-1;;
            pen1.setColor(Qt::white);
            fruit_grid.at(selected_i).at(selected_j)->setPen(pen1);
            //fruit_grid.at(selected_i).at(selected_j)->setFlag((QGraphicsItem::ItemIsSelectable));
            //std::iter_swap(fruit_grid.at(selected_i).at(selected_j),fruit_grid.at(selected_i).at(selected_j-1));
            //item_template=fruit_grid.at(selected_i).at(selected_j-1);
            //fruit_grid.at(selected_i).at(selected_j-1)=fruit_grid.at(selected_i).at(selected_j);
            //fruit_grid.at(selected_i).at(selected_j)=item_template;
            painter.setBrush(fruit_grid.at(selected_i).at(selected_j)->brush());
            fruit_grid.at(selected_i).at(selected_j)->setBrush(fruit_grid.at(selected_i).at(selected_j-1)->brush());
            fruit_grid.at(selected_i).at(selected_j-1)->setBrush(painter.brush());
            //remove_fruit();
        }
        else{
            qDebug("No click");
        }

    }
    else{
        qDebug("click");

        pen1.setColor(Qt::black);

        for (unsigned long i = 0; i < fruit_grid.size(); i++) {
            //qDebug("loop1");
            for (unsigned long j = 0; j < fruit_grid.at(i).size(); j++) {
                //qDebug("loop2");
                if(fruit_grid.at(i).at(j)->contains(click->localPos()) && fruit_grid.at(i).at(j)->brush()!=Qt::white){
                    fruit_grid.at(i).at(j)->setPen(pen1);
                    //fruit_grid.at(i).at(j)->setFlag(QGraphicsItem::ItemIsSelectable);
                    selected=true;
                    selected_j=j;
                    selected_i=i;
                    qDebug()<< "C,R" << i <<","<<j;;
                }
            }
        }
    }





}

void MainWindow::init_titles()
{
    // Displaying column titles, starting from A
    for(int i = 0, letter = 'A'; i < COLUMNS; ++i, ++letter)
    {
        int shift = 5;
        QString letter_string = "";
        letter_string.append(letter);
        QLabel* label = new QLabel(letter_string, this);
        label->setGeometry(LEFT_MARGIN + shift + i * SQUARE_SIDE,
                           TOP_MARGIN - SQUARE_SIDE,
                           SQUARE_SIDE, SQUARE_SIDE);
    }

    // Displaying row titles, starting from A
    for(int i = 0, letter = 'A'; i < ROWS; ++i, ++letter)
    {
        QString letter_string = "";
        letter_string.append(letter);
        QLabel* label = new QLabel(letter_string, this);
        label->setGeometry(LEFT_MARGIN - SQUARE_SIDE,
                           TOP_MARGIN + i * SQUARE_SIDE,
                           SQUARE_SIDE, SQUARE_SIDE);
    }
}

void MainWindow::draw_fruit()
{
    // Vector of fruits
    const std::vector<std::string>
            fruits = {"cherries", "strawberry", "orange", "pear", "apple",
                      "bananas", "tomato", "grapes", "eggplant"};

    // Defining where the images can be found and what kind of images they are
    const std::string PREFIX(":/");
    const std::string SUFFIX(".png");

    // Converting image (png) to a pixmap
    int i = 0; // try different values in 0 <= i < fruits.size()
    std::string filename = PREFIX + fruits.at(i) + SUFFIX;
    QPixmap image(QString::fromStdString(filename));

    // Scaling the pixmap
    image = image.scaled(SQUARE_SIDE, SQUARE_SIDE);

    // Setting the pixmap for a new label
    QLabel* label = new QLabel("test", this);
    label->setGeometry(LEFT_MARGIN + COLUMNS * SQUARE_SIDE,
                       TOP_MARGIN + ROWS * SQUARE_SIDE,
                       SQUARE_SIDE, SQUARE_SIDE);
    label->setPixmap(image);
}

void MainWindow::store_fruit()
{

    int rand = distr_(randomEng_);
    QPixmap pix(SQUARE_SIDE,SQUARE_SIDE);
    pix.fill(Qt::white);
    QPainter painter(&pix);
    switch (rand) {
      case PLUM:
        painter.setBrush(Qt::magenta);
        painter.setPen(Qt::white);
        break;
      case STRAWBERRY:
        painter.setBrush(Qt::red);
        painter.setPen(Qt::white);
        break;
      case APPLE:
        painter.setBrush(Qt::green);
        painter.setPen(Qt::white);
        break;
      case LEMON:
        painter.setBrush(Qt::yellow);
        painter.setPen(Qt::white);
        break;
      case BLUEBERRY:
        painter.setBrush(Qt::blue);
        painter.setPen(Qt::white);
        break;
      case ORANGE:
        painter.setBrush(Qt::darkYellow);
        painter.setPen(Qt::white);
        break;
    }
    painter.drawText(QPoint(50, 50), "12");

    if(fruit_grid.empty()){
        unsigned long long_row = ROWS;
        unsigned long long_test=2;
        if(fruit_row.size()<long_row){
            if(fruit_row.size()>=long_test  && fruit_row.empty()==false){
                if(painter.brush()==fruit_row.at(fruit_row.size()-1)->brush()){
                    if(painter.brush()==fruit_row.at(fruit_row.size()-2)->brush()){
                        store_fruit();
                    }
                }
            }
            QGraphicsRectItem* rectangle =
                    scene_->addRect((SQUARE_SIDE*fruit_row.size()), 0, SQUARE_SIDE, SQUARE_SIDE,
                                    painter.pen(), painter.brush());

            fruit_row.push_back(rectangle);
        }
        else{
            fruit_grid.push_back(fruit_row);
            fruit_row.clear();
            QGraphicsRectItem* rectangle =
                    scene_->addRect(0, SQUARE_SIDE, SQUARE_SIDE, SQUARE_SIDE,
                                    painter.pen(), painter.brush());
            fruit_row.push_back(rectangle);
        }

    }
    //If fruit_grid contains at lest one fruit_row
    else{
        unsigned long long_row = ROWS;
        unsigned long long_test=2;
        if(fruit_row.size()<long_row){
            if(fruit_row.size()>=long_test && fruit_row.empty()==false){
                if(painter.brush()==fruit_row.at(fruit_row.size()-1)->brush()){
                    if(painter.brush()==fruit_row.at(fruit_row.size()-2)->brush()){
                        store_fruit();
                    }
                }
            }
            if(fruit_grid.size()>=long_test && fruit_row.empty()==false){
                if(painter.brush()==fruit_grid.at(fruit_grid.size()-1).at(fruit_row.size())->brush()){
                    if(painter.brush()==fruit_grid.at(fruit_grid.size()-2).at(fruit_row.size())->brush()){
                        store_fruit();
                    }
                }
            }
            QGraphicsRectItem* rectangle =
                    scene_->addRect((SQUARE_SIDE*fruit_row.size()), (SQUARE_SIDE*fruit_grid.size()), SQUARE_SIDE, SQUARE_SIDE,
                                    painter.pen(), painter.brush());
            fruit_row.push_back(rectangle);
        }
        else{
            fruit_grid.push_back(fruit_row);
            fruit_row.clear();
            QGraphicsRectItem* rectangle =
                    scene_->addRect(0, (SQUARE_SIDE*fruit_grid.size()), SQUARE_SIDE, SQUARE_SIDE,
                                    painter.pen(), painter.brush());
            fruit_row.push_back(rectangle);
        }
    }


}
//remove 3 fruits
void MainWindow::remove_fruit()
{
    //cordinates of the fruit line/row
    QPixmap pix(SQUARE_SIDE,SQUARE_SIDE);
    pix.fill(Qt::white);
    QPainter painter(&pix);
    //check collumns and rows for possible combo
    unsigned long long_test=2;
    for (unsigned long i = 0; i < fruit_grid.size(); i++) {
        for (unsigned long j = 0; j < fruit_grid.at(i).size(); j++) {
            if(fruit_grid.at(i).size()>=long_test && fruit_grid.at(i).at(j)->brush()!=Qt::white){
                painter.setBrush(fruit_grid.at(i).at(j)->brush());
                    if(painter.brush()==fruit_grid.at(i).at(j-1)->brush()){
                        if(painter.brush()==fruit_grid.at(i).at(j-2)->brush()){
                            painter.setBrush(Qt::white);
                            //add remove part here
                            fruit_grid.at(i).at(j)->setBrush(painter.brush());
                            fruit_grid.at(i).at(j-1)->setBrush(painter.brush());
                            fruit_grid.at(i).at(j-2)->setBrush(painter.brush());

                        }
                    }
                }
            if(i>=long_test && fruit_grid.at(i).at(j)->brush()!=Qt::white){
                if(painter.brush()==fruit_grid.at(i-1).at(j)->brush()){
                    if(painter.brush()==fruit_grid.at(i-2).at(j)->brush()){
                        painter.setBrush(Qt::white);
                        //add remove part here
                        fruit_grid.at(i).at(j)->setBrush(painter.brush());
                        fruit_grid.at(i-1).at(j)->setBrush(painter.brush());
                        fruit_grid.at(i-2).at(j)->setBrush(painter.brush());
                    }
                }
            }
        }

    }
}
