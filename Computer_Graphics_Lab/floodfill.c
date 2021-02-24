#include<graphics.h>

void putpixels(int x, int y){
    if(getpixel(x,y)!=0)
        return;
    putpixel(x,y,BLUE);
    putpixels(x-1,y);
    putpixels(x+1,y);
    putpixels(x,y-1);
    putpixels(x,y+1);
}

int main(){
    int gd = DETECT, gm;
    initgraph(&gd, &gm, NULL);
    setcolor(RED);
    rectangle(100,100,300,300);
    putpixels(200,200);
    getch();
    closegraph();
    return 0;
}