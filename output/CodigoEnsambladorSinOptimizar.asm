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
    sub     esp, 8
    mov     eax, dword 0
    mov     dword [ebp-4], eax
    mov     eax, dword [ebp+8]
    cmp     eax, dword [ebp-4]
    je      e2
    mov     eax, dword 0
    mov     dword [ebp-8], eax
    jmp     e3
e2:
    mov     eax, dword -1
    mov     dword [ebp-8], eax
e3:
    mov     eax, dword [ebp-8]
    add     esp, 8
    pop     ebp
    ret
e0:
    push    ebp
    mov     ebp, esp 
    sub     esp, 124
    mov     eax, dword 0
    mov     dword [ebp-4], eax
    mov     eax, dword [ebp-4]
    mov     dword [ebp-8], eax
    mov     eax, dword 0
    mov     dword [ebp-12], eax
    mov     eax, dword [ebp-12]
    mov     dword [ebp-16], eax
    lea     eax,  [ebp-8]
    push    eax
    push    formatInt 
    call    _scanf
    add     esp, 8
    lea     eax,  [ebp-16]
    push    eax
    push    formatInt 
    call    _scanf
    add     esp, 8
    mov     eax, dword [ebp-8]
    mov     ebx, dword [ebp-16]
    add     eax, ebx
    mov     dword [ebp-20], eax
    mov     eax, dword [ebp-20]
    call    printNumber
    push    barraN
    call    _printf
    add     esp, 4
    mov     eax, dword [ebp-8]
    mov     ebx, dword [ebp-16]
    sub     eax, ebx
    mov     dword [ebp-24], eax
    mov     eax, dword [ebp-24]
    call    printNumber
    push    barraN
    call    _printf
    add     esp, 4
    mov     eax, dword [ebp-8]
    imul    dword [ebp-16]
    mov     dword [ebp-28], eax
    mov     eax, dword [ebp-28]
    call    printNumber
    push    barraN
    call    _printf
    add     esp, 4
    mov     eax, dword [ebp-8]
    xor     edx, edx
    idiv    dword [ebp-16]
    mov     dword [ebp-32], eax
    mov     eax, dword [ebp-32]
    call    printNumber
    push    barraN
    call    _printf
    add     esp, 4
    mov     eax, dword [ebp-8]
    xor     edx, edx
    idiv    dword [ebp-16]
    mov     dword [ebp-36], edx
    mov     eax, dword [ebp-36]
    call    printNumber
    push    barraN
    call    _printf
    add     esp, 4
    mov     eax, dword [ebp-8]
    cmp     eax, dword [ebp-16]
    je      e4
    mov     eax, dword 0
    mov     dword [ebp-40], eax
    jmp     e5
e4:
    mov     eax, dword -1
    mov     dword [ebp-40], eax
e5:
    mov     eax, dword [ebp-40]
    call    printBool
    push    barraN
    call    _printf
    add     esp, 4
    mov     eax, dword [ebp-8]
    cmp     eax, dword [ebp-16]
    jne     e6
    mov     eax, dword 0
    mov     dword [ebp-44], eax
    jmp     e7
e6:
    mov     eax, dword -1
    mov     dword [ebp-44], eax
e7:
    mov     eax, dword [ebp-44]
    call    printBool
    push    barraN
    call    _printf
    add     esp, 4
    mov     eax, dword [ebp-8]
    cmp     eax, dword [ebp-16]
    jl      e8
    mov     eax, dword 0
    mov     dword [ebp-48], eax
    jmp     e9
e8:
    mov     eax, dword -1
    mov     dword [ebp-48], eax
e9:
    mov     eax, dword [ebp-48]
    call    printBool
    push    barraN
    call    _printf
    add     esp, 4
    mov     eax, dword [ebp-8]
    cmp     eax, dword [ebp-16]
    jle     e10
    mov     eax, dword 0
    mov     dword [ebp-52], eax
    jmp     e11
e10:
    mov     eax, dword -1
    mov     dword [ebp-52], eax
e11:
    mov     eax, dword [ebp-52]
    call    printBool
    push    barraN
    call    _printf
    add     esp, 4
    mov     eax, dword [ebp-8]
    cmp     eax, dword [ebp-16]
    jg      e12
    mov     eax, dword 0
    mov     dword [ebp-56], eax
    jmp     e13
e12:
    mov     eax, dword -1
    mov     dword [ebp-56], eax
e13:
    mov     eax, dword [ebp-56]
    call    printBool
    push    barraN
    call    _printf
    add     esp, 4
    mov     eax, dword [ebp-8]
    cmp     eax, dword [ebp-16]
    jge     e14
    mov     eax, dword 0
    mov     dword [ebp-60], eax
    jmp     e15
e14:
    mov     eax, dword -1
    mov     dword [ebp-60], eax
e15:
    mov     eax, dword [ebp-60]
    call    printBool
    push    barraN
    call    _printf
    add     esp, 4
    mov     eax, dword 4
    mov     dword [ebp-64], eax
    mov     eax, dword [ebp-8]
    imul    dword [ebp-64]
    mov     dword [ebp-68], eax
    mov     eax, dword [ebp-68]
    call    printNumber
    push    barraN
    call    _printf
    add     esp, 4
    mov     eax, dword 4
    mov     dword [ebp-72], eax
    mov     eax, dword [ebp-8]
    xor     edx, edx
    idiv    dword [ebp-72]
    mov     dword [ebp-76], eax
    mov     eax, dword [ebp-76]
    call    printNumber
    push    barraN
    call    _printf
    add     esp, 4
    mov     eax, dword -1
    mov     dword [ebp-80], eax
    mov     eax, dword [ebp-80]
    mov     dword [ebp-84], eax
    mov     eax, dword -1
    mov     dword [ebp-88], eax
    mov     eax, dword [ebp-88]
    mov     dword [ebp-92], eax
    lea     eax,  [ebp-84]
    push    eax
    mov     dword [ebp-84], eax
    push    formatInt 
    call    _scanf
    add     esp, 8
    mov     eax, dword [ebp-84]
    call    readBool
    mov     dword [ebp-84], eax
    lea     eax,  [ebp-92]
    push    eax
    mov     dword [ebp-92], eax
    push    formatInt 
    call    _scanf
    add     esp, 8
    mov     eax, dword [ebp-92]
    call    readBool
    mov     dword [ebp-92], eax
    push    dword [ebp-84]
    call    e1
    mov     dword [ebp-96], eax
    add     esp, 4
    mov     eax, dword [ebp-96]
    mov     dword [ebp-100], eax
    mov     eax, dword [ebp-100]
    call    printBool
    push    barraN
    call    _printf
    add     esp, 4
    push    dword [ebp-92]
    call    e1
    mov     dword [ebp-104], eax
    add     esp, 4
    mov     eax, dword [ebp-104]
    mov     dword [ebp-108], eax
    mov     eax, dword [ebp-108]
    call    printBool
    push    barraN
    call    _printf
    add     esp, 4
    mov     eax, dword [ebp-84]
    mov     ebx, dword [ebp-92]
    and     eax, ebx
    mov     dword [ebp-112], eax
    mov     eax, dword [ebp-112]
    call    printBool
    push    barraN
    call    _printf
    add     esp, 4
    mov     eax, dword [ebp-84]
    mov     ebx, dword [ebp-92]
    or      eax, ebx
    mov     dword [ebp-116], eax
    mov     eax, dword [ebp-116]
    call    printBool
    push    barraN
    call    _printf
    add     esp, 4
    mov     eax, dword [ebp-84]
    cmp     eax, dword [ebp-92]
    je      e16
    mov     eax, dword 0
    mov     dword [ebp-120], eax
    jmp     e17
e16:
    mov     eax, dword -1
    mov     dword [ebp-120], eax
e17:
    mov     eax, dword [ebp-120]
    call    printBool
    push    barraN
    call    _printf
    add     esp, 4
    mov     eax, dword [ebp-84]
    cmp     eax, dword [ebp-92]
    jne     e18
    mov     eax, dword 0
    mov     dword [ebp-124], eax
    jmp     e19
e18:
    mov     eax, dword -1
    mov     dword [ebp-124], eax
e19:
    mov     eax, dword [ebp-124]
    call    printBool
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
printBool:
    mov     ebx, 0
    cmp     ebx, eax
    je      efalse
    push    strtrue
    jmp     eibf
efalse:
    push    strfalse
eibf:
    call    _printf
    add     esp,4
    ret
readBool:
    cmp     eax, 0
    je      isfalse
    mov     eax, -1
isfalse:
    ret
