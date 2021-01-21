// gd => graphic driver
#include<iostream>
#include<graphics.h>
using namespace std;

int main(){
    int gd = DETECT, gm; 
    initgraph(&gd, &gm, NULL);
    
    setcolor(RED);
    rectangle(150,150,450,250);
    floodfill(151,152,1); 

    setcolor(WHITE);
    rectangle(150,251,450,350);
    floodfill(151,252,1); 

    setcolor(GREEN);
    rectangle(150,351,450,450);
    floodfill(151,352,1); 

    setcolor(BLUE);
    int i=0;
    while(i<360){
        pieslice(300,300,i,i+9,50);
        i+=13;
    }
    circle(300, 300 , 50);

    getch();
    closegraph(); 
    return 0;
}