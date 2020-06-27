section	.text
   global _main    ;must be declared for using gcc
   extern _printf
   extern _scanf
	
_main:             ;tell linker entry point
	
	mov eax, 0
	mov ebx, 0
	mov ecx, 0
	mov edx, 0
	
	push 	integer1 ; address of integer1 (second parameter)
	push 	formatin ; arguments are right to left (first parameter)
	call 	_scanf
	add		esp, 8
	
	mov		eax, [integer1]
	;add 	eax, '0'
	mov		[integer1], eax
    push    integer1
    call    _printf
    add     esp, 4
	
	ret
	
printNumber:
    push eax
    push edx
    xor edx,edx          ;edx:eax = number
    div dword [const10]  ;eax = quotient, edx = remainder
    test eax,eax         ;Is quotient zero?
    je .l1               ; yes, don't display it
    call printNumber     ;Display the quotient
.l1:
	add edx, '0'
	mov [res], edx
	push res
    call _printf  ;Display the remainder
	add esp,4
    pop edx
    pop eax
    ret
	


section .data
msg db "The result is:"
len equ $- msg   
const10:    dd 10

formatin: db "%s", 0
integer1: times 4 db 0 ; 32-bits integer = 4 bytes

segment .bss
res resb 4
