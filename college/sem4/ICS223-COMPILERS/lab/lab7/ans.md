# LAB 7

## Gowrish I 2022BCS0155

### Antlr Installation

Steps Used in Arch linux

- Install `antlr`
```console
sudo pacman -S antlr4
```

- Create `Expr.g` with the following contents
```antlr
grammar Expr;
start: (expr NEWLINE)* ;
expr: expr ('*'|'/') expr
| expr ('+'|'-') expr
| INT
| '(' expr ')'
;
NEWLINE : [\r\n]+ ;
INT : [0-9]+ ;
```

- Create `sample.txt` with the following content
```
2022+0*155

```

- Create a shell script called `antrl` and make it executable
```bash
#!/bin/sh

antlr4 $1.g
javac -classpath /usr/share/java/antlr-4.13.1-complete.jar Expr*.java
grun Expr start ./$2 -gui
```

- Make it an executable
```console
chmod +x antlr
```

- Move it to a directory in `$PATH`
```console
mv antlr ~/.local/bin
```

- Call the shell script
```console
antlr Expr sample.txt
```

- Output
