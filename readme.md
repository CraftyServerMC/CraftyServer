# CraftyServer

**WARNING! THIS PROJECT IS STILL IN DEVELOPEMENT!** At the moment, it lacks most of it functions and is unusable.

![projectstage](https://img.shields.io/badge/project%20stage-developement-red)
![projectstage](https://img.shields.io/badge/version-0.0.1-red)
[![license](https://img.shields.io/github/license/CraftyServerMC/CraftyServer)](https://github.com/CraftyServerMC/CraftyServer/blob/main/LICENSE)
[![issues](https://img.shields.io/github/issues/CraftyServerMC/CraftyServer)](https://github.com/CraftyServerMC/CraftyServer/issues)<br>
[![contributors](https://img.shields.io/github/contributors/CraftyServerMC/CraftyServer)](https://github.com/CraftyServerMC/CraftyServer/graphs/contributors)
[![activity](https://img.shields.io/github/commit-activity/m/CraftyServerMC/CraftyServer)](https://github.com/CraftyServerMC/CraftyServer/commits/main)
[![lastcommit](https://img.shields.io/github/last-commit/CraftyServerMC/CraftyServer)](https://github.com/CraftyServerMC/CraftyServer/commits/main)<br>
![size](https://img.shields.io/github/languages/code-size/CraftyServerMC/CraftyServer)
![files](https://img.shields.io/github/directory-file-count/CraftyServerMC/CraftyServer)
![languages](https://img.shields.io/github/languages/count/CraftyServerMC/CraftyServer)<br>

### Self-written modular multi-version Server for *Minecraft&trade;: Java Edition*

CraftyServer is an **event-based**, **highly modular** multiplayer server for **Minecraft&trade; Java Edition**.  
Depending on the modules installed, it **supportes every "Release"-Version of Minecraft&trade; from 1.8.0 to the newest version** (Currently 1.18.1).  
It is **100% self-written, open source, and copyright-free** (MIT License). It does not use any code from any official release by Mojang&trade;/Microsoft&trade;.  
Even though it can be used to run a Minecraft&trade; Server just for personal use, its main intention is to be used to run as part from an e.g. BungeeCord-driven Server Network.  

Legal disclaimer: This project is not affiliated with Minecraft&trade; or Mojang&trade;/Microsoft&trade; in any way, shape or form.  

## How to install
This Project uses Maven.  
1. Clone the repository: 
```bash
git clone https://github.com/CraftyServerMC/CraftyServer/
```
2. Run inside of e.g. Eclipse, using the default "Run as -> Java Application"-option, or build yourself a `.jar`-file, using Maven:
```bash
mvm install
```  

Once we hit a usable state in developement, there will be some form of installer to actually install and use the server.

## This module: CraftyServer Main
This repository contains the code for the main module, which is the only actually runnable .jar file in the project. If you want to start the server, launch this file.  

#### This module does the following:
 - Provide launchable main class and main method *(Done, but can't be finalized until everything else is done)*
 - Accept connections, recieve, parse and send packages to and from Minecraft Clients *(Done)*
 - Store and access parameters for different client connections *(Not started)*
 - Load, unload, enable and disable modules *(Not started)*
 - Provide Eventmanager & all classes needed for event management *(Works, but misses some features)*
 - Provide data type parser for Minecraft protocol *(VarInt and VarLong are done, others not started)*
 - Provide API to load & save config files *(Works, but misses some features; Might undergo some massive changes)*
 - Provide Logger *(Done)*

#### Why is it its own module?
This is the main module of the server, containing the main method. No other module runs without it.  

#### Maven instructions:
Add the following entries to your pom.xml:
1. Include repository:

```XML
<repositories>
  <repository>
    <id>CraftyServer-mvn-repo</id>
    <url>https://github.com/CraftyServerMC/maven/raw/mvn-repo/</url>
    <snapshots>
      <enabled>true</enabled>
      <updatePolicy>always</updatePolicy>
    </snapshots>
  </repository>
</repositories>
```
2. Include artifact:

```XML
<dependencies>
  <dependency>
    <groupId>org.craftyserver</groupId>
    <artifactId>craftyserver</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <scope>provided</scope>
  </dependency>
</dependencies>
```
