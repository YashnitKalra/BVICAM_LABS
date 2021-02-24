#include<graphics.h>

int main(){
    int gd = DETECT, gm;
    initgraph(&gd, &gm, NULL);
    setcolor(BLUE);
    rectangle(100,100,200,200);
    int x=100, y=100;
    while(getpixel(x+1,y+1)==0){
        while(getpixel(x+1,y+1)==0){
            putpixel(x+1,y+1,RED);
            y++;
        }
        x++;
        y=100;
    }

    getch();
    closegraph();
    return 0;
}