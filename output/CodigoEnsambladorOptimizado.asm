section .data
    formatInt: db "%d", 0 
    formatStr: db "%s", 0 
    const10:    dd 10
    outInt:     dd 0
    strtrue:   db "true",0
    strfalse:  db "false",0
    menos:  db "-",0
    barraN:    db 10,0 
segment .bss
section .text
    global _main
    extern _printf
    extern _scanf
_main:
    jmp     e0
e0:
    push    ebp
    mov     ebp, esp 
    sub     esp, 352
    mov     eax, dword 43
    mov     dword [ebp-344], eax
    mov     eax, dword [ebp-344]
    call    printNumber
    push    barraN
    call    _printf
    add     esp, 4
    mov     eax, dword [ebp-344]
    mov     dword [ebp-344], eax
    shl     dword [ebp-344], 2
    mov     eax, dword [ebp-344]
    call    printNumber
    push    barraN
    call    _printf
    add     esp, 4
    ret
printNumber:
    cmp     eax, 0
    jge     l2
    neg     eax
    push    eax
    push    menos
    call    _printf
    add     esp, 4
    pop     eax
l2:
    push    eax
    push    edx
    xor     edx,edx
    div     dword [const10]
    test    eax,eax
    je      l1
    call    l2
l1:
    add     edx, '0'
    mov     [outInt], edx
    push    outInt
    call    _printf
    add     esp,4
    pop     edx
    pop     eax
    ret
