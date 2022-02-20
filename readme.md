# CraftyServer

**WARNING! THIS PROJECT IS STILL IN DEVELOPEMENT!** At the moment, it lacks most of it functions and is unusable.

CraftyServer is an **event-based**, **highly modular** multiplayer server for **Minecraft&trade; Java Edition**.  
Depending on the modules installed, it **supportes every "Release"-Version of Minecraft&trade; from 1.8.0 to the newest version** (Currently 1.18.1).  
It is **100% self-written, open source, and copyright-free** (MIT License). It does not use any code from any official release by Mojang&trade;/Microsoft&trade;.  
Even though it can be used to run a Minecraft&trade; Server just for personal use, its main intention is to be used to run as part from an e.g. BungeeCord-driven Server Network.  

Legal disclaimer: This project is not affiliated with Minecraft&trade; or Mojang&trade;/Microsoft&trade; in any way, shape or form.  

### How to install
TODO: Write something intelligent here, because I don't know yet myself :)  
This Project uses Maven. So it should work with "git clone" and the "mvn" command.
### How to code custom modules
TODO: Lets get some functionality in first before we can worry about that
### This module: CraftyServer Main
This repository contains the code for the main module, which is the only actually runnable .jar file in the project. If you want to start the server, launch this file.  

**Maven**
TODO: Setup maven

**This module does the following:**
 - Provide launchable main class and main method *(Done, but can't be finalized until everything else is done)*
 - Accept connections, recieve, parse and send packages to and from Minecraft Clients *(Done)*
 - Store and access parameters for different client connections *(Not started)*
 - Load, unload, enable and disable modules *(Not started)*
 - Provide Eventmanager & all classes needed for event management *(Works, but misses some features)*
 - Provide data type parser for Minecraft protocol *(VarInt and VarLong are done, others not started)*
 - Provide API to load & save config files *(Works, but misses some features; Might undergo some massive changes)*
 - Provide Logger *(Done)*