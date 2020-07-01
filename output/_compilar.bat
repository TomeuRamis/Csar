nasm -f win32 -g -F cv8 CodigoEnsambladorSinOptimizar.asm -o codigoSinOptimizar.o 
gcc -m32 codigoSinOptimizar.o -o codigoSinOptimizar.exe

nasm -f win32 -g -F cv8 CodigoEnsambladorOptimizado.asm -o codigoOptimizado.o 
gcc -m32 codigoOptimizado.o -o codigoOptimizado.exe

codigoSinOptimizar.exe
codigoOptimizado.exe

pause