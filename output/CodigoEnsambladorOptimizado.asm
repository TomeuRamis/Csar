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
e1:
    push    ebp
    mov     ebp, esp 
    sub     esp, 0
    mov     eax, dword [ebp+8]
    call    printNumber
    push    barraN
    call    _printf
    add     esp, 4
    add     esp, 0
    pop     ebp
    ret
e2:
    push    ebp
    mov     ebp, esp 
    sub     esp, 56
    mov     eax, dword -1
    mov     dword [ebp-8], eax
    mov     eax, dword 2
    mov     dword [ebp-16], eax
e3:
    mov     eax, dword [ebp+8]
    xor     edx, edx
    mov     ebx, 2
    idiv    ebx
    mov     dword [ebp-24], eax
    mov     eax, dword [ebp-16]
    cmp     eax, dword [ebp-24]
    jle     e4
    mov     eax, dword 0
    mov     dword [ebp-28], eax
    jmp     e5
e4:
    mov     eax, dword -1
    mov     dword [ebp-28], eax
e5:
    mov     eax, dword [ebp-8]
    mov     ebx, dword [ebp-28]
    and     eax, ebx
    mov     dword [ebp-32], eax
    mov     eax, dword 0
    cmp     eax, dword [ebp-32]
    je      e6
    mov     eax, dword [ebp+8]
    xor     edx, edx
    idiv    dword [ebp-16]
    mov     dword [ebp-36], edx
    mov     eax, dword [ebp-36]
    cmp     eax, dword 0
    je      e7
    mov     eax, dword 0
    mov     dword [ebp-44], eax
    jmp     e8
e7:
    mov     eax, dword -1
    mov     dword [ebp-44], eax
e8:
    mov     eax, dword 0
    cmp     eax, dword [ebp-44]
    je      e9
    mov     eax, dword 0
    mov     dword [ebp-8], eax
    jmp     e10
e9:
e10:
    mov     eax, dword 1
    mov     ebx, dword [ebp-16]
    add     eax, ebx
    mov     dword [ebp-16], eax
    jmp     e3
e6:
    mov     eax, dword [ebp-8]
    add     esp, 56
    pop     ebp
    ret
e0:
    push    ebp
    mov     ebp, esp 
    sub     esp, 52
    mov     eax, dword 1
    mov     dword [ebp-8], eax
    mov     eax, dword 0
    mov     dword [ebp-16], eax
    mov     eax, dword 0
    mov     dword [ebp-24], eax
    lea     eax,  [ebp-16]
    push    eax
    push    formatInt 
    call    _scanf
    add     esp, 8
e11:
    mov     eax, dword [ebp-24]
    cmp     eax, dword [ebp-16]
    jl      e12
    mov     eax, dword 0
    mov     dword [ebp-28], eax
    jmp     e13
e12:
    mov     eax, dword -1
    mov     dword [ebp-28], eax
e13:
    mov     eax, dword 0
    cmp     eax, dword [ebp-28]
    je      e14
    push    dword [ebp-8]
    call    e2
    mov     dword [ebp-32], eax
    add     esp, 4
    mov     eax, dword 0
    cmp     eax, dword [ebp-32]
    je      e15
    push    dword [ebp-8]
    call    e1
    add     esp, 4
    mov     eax, dword 1
    mov     ebx, dword [ebp-24]
    add     eax, ebx
    mov     dword [ebp-24], eax
    jmp     e16
e15:
e16:
    mov     eax, dword 1
    mov     ebx, dword [ebp-8]
    add     eax, ebx
    mov     dword [ebp-8], eax
    jmp     e11
e14:
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
