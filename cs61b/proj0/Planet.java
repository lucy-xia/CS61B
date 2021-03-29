public class Planet {
    
    public double xxPos; // Its current x position
    public double yyPos; //Its current y position
    public double xxVel; //Its current velocity in the x direction
    public double yyVel; //Its current velocity in the y direction
    public double mass; //Its current velocity in the y direction
    public String imgFileName; //Its mass
    
    
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }
    
    public Planet(Planet P) {
        this.xxPos = P.xxPos;
        this.yyPos = P.yyPos;
        this.xxVel = P.xxVel;
        this.yyVel = P.yyVel;
        this.mass = P.mass;
        this.imgFileName = P.imgFileName;
    }
    
    public double calcDistance(Planet P){
        double dis1=xxPos-P.xxPos;
        double dis2=yyPos-P.yyPos;
        return Math.sqrt(dis1*dis1+dis2*dis2); //according to r2=dx2+dy2
    }

    public double calcForceExertedBy(Planet P){
        double dis = calcDistance(P);
        return (6.67e-11) * mass * P.mass / (dis*dis); //according to F=G⋅m1⋅m2/(r^2)
    }

    public double calcForceExertedByX(Planet P){ 
        return calcForceExertedBy(P) * (P.xxPos - xxPos) / calcDistance(P); //Fx=F⋅dx/r
    }

    public double calcForceExertedByY(Planet P){ 
        return (calcForceExertedBy(P) * (P.yyPos - yyPos) / calcDistance(P)); //Fy=F⋅dy/r
    }

    public void update(double dt, double fx, double fy){ 
        double xAccel=fx/this.mass; //ax=Fx/m 
        double yAccel=fy/this.mass; // ay=Fy/m
        this.xxVel+=xAccel*dt;  //velocityX=vx+dt⋅ax
        this.yyVel+=yAccel*dt;  //velocityY=vy+dt⋅ay
        this.xxPos+=this.xxVel*dt;  //px+dt⋅vx
        this.yyPos+=this.yyVel*dt;  //py+dt⋅vy
    }
    
    public void draw(){
        StdDraw.picture(xxPos, yyPos, "./images/" + imgFileName);
    }
    
}



