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
    mov     eax, dword 1
    mov     dword [ebp-4], eax
    mov     eax, dword 1
    mov     dword [ebp-8], eax
    mov     eax, dword [ebp-4]
    mov     ebx, dword [ebp-8]
    add     eax, ebx
    mov     dword [ebp-12], eax
    mov     eax, dword 1
    mov     dword [ebp-16], eax
    mov     eax, dword [ebp-12]
    mov     ebx, dword [ebp-16]
    add     eax, ebx
    mov     dword [ebp-20], eax
    mov     eax, dword 1
    mov     dword [ebp-24], eax
    mov     eax, dword [ebp-20]
    mov     ebx, dword [ebp-24]
    add     eax, ebx
    mov     dword [ebp-28], eax
    mov     eax, dword 1
    mov     dword [ebp-32], eax
    mov     eax, dword [ebp-28]
    mov     ebx, dword [ebp-32]
    add     eax, ebx
    mov     dword [ebp-36], eax
    mov     eax, dword 1
    mov     dword [ebp-40], eax
    mov     eax, dword [ebp-36]
    mov     ebx, dword [ebp-40]
    add     eax, ebx
    mov     dword [ebp-44], eax
    mov     eax, dword 1
    mov     dword [ebp-48], eax
    mov     eax, dword [ebp-44]
    mov     ebx, dword [ebp-48]
    add     eax, ebx
    mov     dword [ebp-52], eax
    mov     eax, dword 1
    mov     dword [ebp-56], eax
    mov     eax, dword [ebp-52]
    mov     ebx, dword [ebp-56]
    add     eax, ebx
    mov     dword [ebp-60], eax
    mov     eax, dword 1
    mov     dword [ebp-64], eax
    mov     eax, dword [ebp-60]
    mov     ebx, dword [ebp-64]
    add     eax, ebx
    mov     dword [ebp-68], eax
    mov     eax, dword 1
    mov     dword [ebp-72], eax
    mov     eax, dword [ebp-68]
    mov     ebx, dword [ebp-72]
    add     eax, ebx
    mov     dword [ebp-76], eax
    mov     eax, dword 1
    mov     dword [ebp-80], eax
    mov     eax, dword [ebp-76]
    mov     ebx, dword [ebp-80]
    add     eax, ebx
    mov     dword [ebp-84], eax
    mov     eax, dword 1
    mov     dword [ebp-88], eax
    mov     eax, dword [ebp-84]
    mov     ebx, dword [ebp-88]
    add     eax, ebx
    mov     dword [ebp-92], eax
    mov     eax, dword 1
    mov     dword [ebp-96], eax
    mov     eax, dword [ebp-92]
    mov     ebx, dword [ebp-96]
    add     eax, ebx
    mov     dword [ebp-100], eax
    mov     eax, dword 1
    mov     dword [ebp-104], eax
    mov     eax, dword [ebp-100]
    mov     ebx, dword [ebp-104]
    add     eax, ebx
    mov     dword [ebp-108], eax
    mov     eax, dword 1
    mov     dword [ebp-112], eax
    mov     eax, dword [ebp-108]
    mov     ebx, dword [ebp-112]
    add     eax, ebx
    mov     dword [ebp-116], eax
    mov     eax, dword 1
    mov     dword [ebp-120], eax
    mov     eax, dword [ebp-116]
    mov     ebx, dword [ebp-120]
    add     eax, ebx
    mov     dword [ebp-124], eax
    mov     eax, dword 1
    mov     dword [ebp-128], eax
    mov     eax, dword [ebp-124]
    mov     ebx, dword [ebp-128]
    add     eax, ebx
    mov     dword [ebp-132], eax
    mov     eax, dword 1
    mov     dword [ebp-136], eax
    mov     eax, dword [ebp-132]
    mov     ebx, dword [ebp-136]
    add     eax, ebx
    mov     dword [ebp-140], eax
    mov     eax, dword 1
    mov     dword [ebp-144], eax
    mov     eax, dword [ebp-140]
    mov     ebx, dword [ebp-144]
    add     eax, ebx
    mov     dword [ebp-148], eax
    mov     eax, dword 1
    mov     dword [ebp-152], eax
    mov     eax, dword [ebp-148]
    mov     ebx, dword [ebp-152]
    add     eax, ebx
    mov     dword [ebp-156], eax
    mov     eax, dword 1
    mov     dword [ebp-160], eax
    mov     eax, dword [ebp-156]
    mov     ebx, dword [ebp-160]
    add     eax, ebx
    mov     dword [ebp-164], eax
    mov     eax, dword 1
    mov     dword [ebp-168], eax
    mov     eax, dword [ebp-164]
    mov     ebx, dword [ebp-168]
    add     eax, ebx
    mov     dword [ebp-172], eax
    mov     eax, dword 1
    mov     dword [ebp-176], eax
    mov     eax, dword [ebp-172]
    mov     ebx, dword [ebp-176]
    add     eax, ebx
    mov     dword [ebp-180], eax
    mov     eax, dword 1
    mov     dword [ebp-184], eax
    mov     eax, dword [ebp-180]
    mov     ebx, dword [ebp-184]
    add     eax, ebx
    mov     dword [ebp-188], eax
    mov     eax, dword 1
    mov     dword [ebp-192], eax
    mov     eax, dword [ebp-188]
    mov     ebx, dword [ebp-192]
    add     eax, ebx
    mov     dword [ebp-196], eax
    mov     eax, dword 1
    mov     dword [ebp-200], eax
    mov     eax, dword [ebp-196]
    mov     ebx, dword [ebp-200]
    add     eax, ebx
    mov     dword [ebp-204], eax
    mov     eax, dword 1
    mov     dword [ebp-208], eax
    mov     eax, dword [ebp-204]
    mov     ebx, dword [ebp-208]
    add     eax, ebx
    mov     dword [ebp-212], eax
    mov     eax, dword 1
    mov     dword [ebp-216], eax
    mov     eax, dword [ebp-212]
    mov     ebx, dword [ebp-216]
    add     eax, ebx
    mov     dword [ebp-220], eax
    mov     eax, dword 1
    mov     dword [ebp-224], eax
    mov     eax, dword [ebp-220]
    mov     ebx, dword [ebp-224]
    add     eax, ebx
    mov     dword [ebp-228], eax
    mov     eax, dword 1
    mov     dword [ebp-232], eax
    mov     eax, dword [ebp-228]
    mov     ebx, dword [ebp-232]
    add     eax, ebx
    mov     dword [ebp-236], eax
    mov     eax, dword 1
    mov     dword [ebp-240], eax
    mov     eax, dword [ebp-236]
    mov     ebx, dword [ebp-240]
    add     eax, ebx
    mov     dword [ebp-244], eax
    mov     eax, dword 1
    mov     dword [ebp-248], eax
    mov     eax, dword [ebp-244]
    mov     ebx, dword [ebp-248]
    add     eax, ebx
    mov     dword [ebp-252], eax
    mov     eax, dword 1
    mov     dword [ebp-256], eax
    mov     eax, dword [ebp-252]
    mov     ebx, dword [ebp-256]
    add     eax, ebx
    mov     dword [ebp-260], eax
    mov     eax, dword 1
    mov     dword [ebp-264], eax
    mov     eax, dword [ebp-260]
    mov     ebx, dword [ebp-264]
    add     eax, ebx
    mov     dword [ebp-268], eax
    mov     eax, dword 1
    mov     dword [ebp-272], eax
    mov     eax, dword [ebp-268]
    mov     ebx, dword [ebp-272]
    add     eax, ebx
    mov     dword [ebp-276], eax
    mov     eax, dword 1
    mov     dword [ebp-280], eax
    mov     eax, dword [ebp-276]
    mov     ebx, dword [ebp-280]
    add     eax, ebx
    mov     dword [ebp-284], eax
    mov     eax, dword 1
    mov     dword [ebp-288], eax
    mov     eax, dword [ebp-284]
    mov     ebx, dword [ebp-288]
    add     eax, ebx
    mov     dword [ebp-292], eax
    mov     eax, dword 1
    mov     dword [ebp-296], eax
    mov     eax, dword [ebp-292]
    mov     ebx, dword [ebp-296]
    add     eax, ebx
    mov     dword [ebp-300], eax
    mov     eax, dword 1
    mov     dword [ebp-304], eax
    mov     eax, dword [ebp-300]
    mov     ebx, dword [ebp-304]
    add     eax, ebx
    mov     dword [ebp-308], eax
    mov     eax, dword 1
    mov     dword [ebp-312], eax
    mov     eax, dword [ebp-308]
    mov     ebx, dword [ebp-312]
    add     eax, ebx
    mov     dword [ebp-316], eax
    mov     eax, dword 1
    mov     dword [ebp-320], eax
    mov     eax, dword [ebp-316]
    mov     ebx, dword [ebp-320]
    add     eax, ebx
    mov     dword [ebp-324], eax
    mov     eax, dword 1
    mov     dword [ebp-328], eax
    mov     eax, dword [ebp-324]
    mov     ebx, dword [ebp-328]
    add     eax, ebx
    mov     dword [ebp-332], eax
    mov     eax, dword 1
    mov     dword [ebp-336], eax
    mov     eax, dword [ebp-332]
    mov     ebx, dword [ebp-336]
    add     eax, ebx
    mov     dword [ebp-340], eax
    mov     eax, dword [ebp-340]
    mov     dword [ebp-344], eax
    mov     eax, dword [ebp-344]
    call    printNumber
    push    barraN
    call    _printf
    add     esp, 4
    mov     eax, dword 4
    mov     dword [ebp-348], eax
    mov     eax, dword [ebp-344]
    imul    dword [ebp-348]
    mov     dword [ebp-352], eax
    mov     eax, dword [ebp-352]
    mov     dword [ebp-344], eax
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
