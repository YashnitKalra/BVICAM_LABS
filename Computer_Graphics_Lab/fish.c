#include<graphics.h>

int main(){
    int gd = DETECT, gm;
    initgraph(&gd, &gm, NULL);
    for(int x=0;x<400;x++){
        cleardevice();
        ellipse(x+90,200,0,360,70,25);
        circle(x+140,195,5);
        int triangle[] = {x+20,200,x,190,x,210,x+20,200};
        drawpoly(4, &triangle[0]);
    }
    getch();
    closegraph();

    return 0;
}