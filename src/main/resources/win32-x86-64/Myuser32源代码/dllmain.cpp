// dllmain.cpp : 定义 DLL 应用程序的入口点。MyUser32.dll 的源代码
#include "pch.h"
#include <iostream>
#include <windows.h>
#include <psapi.h>
#include <iostream>
#include <string>
#include <vector>
#include <string>
#include <comdef.h>
#include <map>
#include <tlhelp32.h>
#define DLLEXPORT extern "C" __declspec(dllexport)

// grt ProcessID
DLLEXPORT DWORD getProcessIDByWindowName(LPCWSTR WindowName) {
 
   
    // 获取窗口句柄
    HWND hwnd = FindWindow(NULL, WindowName);
    if (hwnd == NULL) {
        std::cerr << "找不到窗口 EC1\n";
        return 1;
    }
    DWORD pid;
    GetWindowThreadProcessId(hwnd, &pid);
    if (pid==NULL)
    {
        std::cerr << "get pid faild EC2\n";
        return 2;
    }
    else 
    {
        std::cout << "Hello Pal";
        std::cout << "Hello Pal"<< std::endl;
        return pid;
    }
}
DLLEXPORT HANDLE openProcessByPID(DWORD pid){
    HANDLE process = OpenProcess(PROCESS_ALL_ACCESS, FALSE, pid);
    if (process == NULL) {
        std::cerr << "无法打开进程 EC1\n";
        return NULL;
    }

    HMODULE hMod;
    DWORD cbNeeded;
    if (!EnumProcessModules(process, &hMod, sizeof(hMod), &cbNeeded)) {
        std::cerr << "无法枚举进程模块 EC2\n";
        return NULL;
    }

    MODULEINFO modInfo;
    if (!GetModuleInformation(process, hMod, &modInfo, sizeof(modInfo))) {
        std::cerr << "无法获取模块信息 EC3\n";
        return NULL;
    }

    std::cout << "模块的基址是：" << modInfo.lpBaseOfDll << std::endl;

    return process;
}

//get all process Name and pid
struct KeyValuePair
{
    DWORD key;
    BSTR value;
};
DLLEXPORT KeyValuePair* GetProcessList(int* length)
{
    std::vector<KeyValuePair> processList;

    HANDLE hProcessSnap;
    PROCESSENTRY32 pe32;

    hProcessSnap = CreateToolhelp32Snapshot(TH32CS_SNAPPROCESS, 0);
    if (hProcessSnap == INVALID_HANDLE_VALUE)
    {
        *length = 0;
        return nullptr;
    }

    pe32.dwSize = sizeof(PROCESSENTRY32);

    if (!Process32First(hProcessSnap, &pe32))
    {
        CloseHandle(hProcessSnap);
        *length = 0;
        return nullptr;
    }

    do
    {
        KeyValuePair pair;
        pair.key = pe32.th32ProcessID;
        pair.value = SysAllocString(pe32.szExeFile);
        processList.push_back(pair);
    } while (Process32Next(hProcessSnap, &pe32));

    CloseHandle(hProcessSnap);

    KeyValuePair* result = new KeyValuePair[processList.size()];
    memcpy(result, processList.data(), processList.size() * sizeof(KeyValuePair));
    *length = processList.size();
    return result;
}