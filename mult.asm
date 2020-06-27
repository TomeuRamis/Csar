section	.text
   global _main    ;must be declared for using gcc
   extern _printf
	
_main:             ;tell linker entry point
	
	
	mov eax, 0
	mov ebx, 0
	mov ecx, 0
	mov edx, 0

	mov	eax,50
	sub eax, 0
	mov ebx, 5
	sub ebx, 0
	mul ebx
   
    mov  [res], eax
   
    push    msg
    call    _printf
    add     esp, 4
    
	mov  eax,[res]
    jmp printNumber
	
	hlt
	
;Input
; eax = number to display

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

segment .bss
res resb 4
