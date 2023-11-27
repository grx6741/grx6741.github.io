# Project Structuring

## Agenda

- Object-Oriented Programming
- Project Structuring

### Object-Oriented Programming
 Object-Oriented Programming
- Take Flappy bird
  - First, the bird. Here are all the necessary variables and methods
  ```
  position
  velocity
  acceleration
  image

  fall()
  flap()
  ```

  - Here is the naive approach
  ```python
  #python 

  bird_position = Vector2(WIDTH//2, HEIGHT//2)
  bird_velocity = Vector2(0, 0)
  bird_acceleration = Vector2(0, 30)

  def bird_fall(dt):
      global bird_position, bird_velocity
      bird_velocity += bird_acceleration * dt
      bird_position += bird_velocity * dt

  def bird_flap():
      global bird_velocity
      bird_velocity = Vector(0, -50)
  ```

  - The problem with the above code is that all the variables
  associated with bird needs to be prefixed with the word 'bird' and the 
  functions are modifying global variables. We'll first fix this 
  situation in C language by using structs.

  ```c
  // C
  struct bird {
      Vector2 pos;
      Vector2 vel;
      Vector2 acc;
  };
  
  struct bird flappyBird;
  flappyBird.pos.x = WIDTH/2;
  flappyBird.pos.y = HEIGHT/2;

  flappyBird.vel.x = 0;
  flappyBird.vel.y = 0;

  flappyBird.acc.x = 0;
  flappyBird.acc.y = -30;

  void bird_flap(struct bird flappyBird) {
      flappyBird.vel.y = -50;
  }
  bird_flap(flappyBird);

  void bird_flap(struct bird* flappyBird) {
      flappyBird->vel.y = -50;
  }
  bird_flap(&flappyBird);
  ```

  - The problem with above code is that initialization of a struct
  is too big. If one had to initialize a bunch of structs he might have to 
  use a for loop. To fix this C++ has brought a special function called
  as a constructor that does the initialization part.

  ```cpp
  // C++

  struct bird {
  private:
      Vector2 pos;
      Vector2 vel;
      Vector2 acc;

  public:
      // Constructor
      bird(int posx, int posy, int velx, int vely, int accx, int accy) {
          pos.x = posx;
          pos.y = posy;

          vel.x = velx;
          vel.y = vely;

          acc.x = accx;

          // below both are the same
          acc.y = accy;
          this->acc.y = accy;
      }

      void flap() {
          vel.y = -50;
      }
  };

  //  Constructor is called when creating an instance of the struct
  bird flappyBird(WIDTH/2, HEIGHT/2, 0, 0, 0, -30);
  // flappyBird.pos.x = 10;
  flappyBird.flap();
  ```

  - By default, all member variables and methods (functions) in a struct
  are public by default but in a class all of them are private by default.
  But it doesn't matter if you use a class or a struct in C++ if you properly tell what variables are public
  and what are private.

  - Here's what the same code in C++ looks like in python

  ```python
  class bird:
      # Constructor
      # self. in python is the same as this-> in C++
      def __init__(self, pos, vel, acc):
          self.pos = pos
          self.vel = vel
          self.acc = acc

      def flap(self):
          self.vel = Vector2(0, -50)

  flappyBird = bird(Vector2(WIDTH//2, HEIGHT//2), Vector2(0, 0), Vector2(0, -30))
  flappyBird.flap()
  ```
- Now the same way the pipes in Flappy bird are also abstracted into a class

- Now that you have two classes, where would you place them in a project.
We can't place all the classes in the same file, that's not good practice.

### Project Structuring

- Command

    ```python
    def update(dt):
        keys = pygame.keys.get_pressed()

        if keys[pygame.K_k]: lightAttack()
        if keys[pygame.K_l]: heavyAttack()
    ```
