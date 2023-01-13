#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>

QT_BEGIN_NAMESPACE
namespace Ui { class MainWindow; }
QT_END_NAMESPACE

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    MainWindow(QWidget *parent = nullptr);
    ~MainWindow();

private slots:
    void on_countButton_clicked();

    void on_weightLineEdit_editingFinished();

    void on_heightLineEdit_editingFinished();

private:
    Ui::MainWindow *ui;
    double height=0;
    double weight=0;
};
#endif // MAINWINDOW_H
