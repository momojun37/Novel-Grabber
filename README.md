# ![alt text](https://i.imgur.com/LrV2tLe.png)Novel-Grabber
Novel-Grabber is a gui based web scrapper that can download and convert chapters into EPUB from various supported web/light novel sites or from any other site manually.


## Natively supported sites

| [Wuxiaworld](https://wuxiaworld.com/) | [Royalroad](https://royalroad.com/) | [FoxTeller](https://foxteller.com/)|
| :--- | :--- | :--- |
| <b>[Volarenovels](https://volarenovels.com/)</b>| <b>[Creative Novels](https://https://creativenovels.com/.com/)</b> | <b>[WordExcerpt](https://wordexcerpt.com/)</b>|
| <b>[Dreame](https://dreame.com/)</b> | <b>[TapRead](https://www.tapread.com/)</b> | <b>[Zenith Novels](https://zenithnovels.com/)</b>|
| <b>[Kuhaku Light Novel Translations](https://kuhakulightnoveltranslations.com/)</b> | <b>[Translation Otaku](https://translatinotaku.net/)</b> | <b>[ISO Hungry TLS](https://isohungrytls.com/)</b>|
| <b>[Chrysanthemum Garden](https://chrysanthemumgarden.com/)</b> | <b>[FanFiction](https://fanfiction.net/)</b> | <b>[BoxNovel](https://boxnovel.com/)</b>|
| <b>[LiberSpark](https://liberspark.com/)</b> |<b>[Wordrain](https://wordrain69.com/)</b> | <b>[Comrade Mao](https://comrademao.com/)</b>|
| <b>[Light Novels Translations](https://lightnovelstranslations.com/)</b> | <b>[Ebisu Translations](https://ebisutranslations.com/)</b> | <b>[Webnovel](https://webnovel.com/)</b>
| <b>[Wattpad](https://wattpad.com/)</b> | <b>[WuxiaWorld.online](https://wuxiaworld.online/)</b> | <b>[Booklat](https://booklat.com.ph/)</b>
| <b>[WuxiaWorld.site](https://wuxiaworld.site/)</b> | <b>[FicFun](https://ficfun.com/)</b> | <b>[Novel Full](http://novelfull.com/)</b> 
| <b>[Foxaholic](https://foxaholic.com/)</b> | <b>[FanFiktion](https://fanfiktion.de/)</b> | <b>[Scribble Hub](https://scribblehub.com/)</b>

## How to use
<strong>Automatic:</strong>

1. Download and execute the [NovelGrabber.jar](https://github.com/Flameish/Novel-Grabber/releases/latest) of the latest release
(If you can't execute the jar, try navigating to the jar location with cmd/terminal and use: `java -jar Novel-Grabber.jar`)
2. Enter the link to the novel's Table of Contents page
3. Click on 'Check' to fetch novel info and chapter list
4. Grab chapters

* Options:

   <b>Invert chapter order</b> will start to download the last chapter of the Table of Contents page first. Helpful if sites list the most recent chapter at the top.
   
   <b>Get images</b> downloads potential images in a chapter.
   
   <b>Add chapter title</b> will insert the chapter title at the top of the chapter page.
      
   <b>Remove styling</b> gets rid of all original css styling of the chapter.
   
   <b>Headerless Browser</b> will visit the websites with the selected browser. Use this if websites are blocked by Cloudflare or when chapters are dynamically loaded. (Some hosts are set to always use headerless)
   
   <b>Wait time</b> is the time between each chapter call in milliseconds (1000 for 1 second) (so you don't flood the host server with requests)
   
   <b>Edit metadata</b>(pen icon) lets you edit Title, Author, Tags, Description and Cover image of the novel.
   
   <b>Edit blacklisted tags</b>(block icon) enables you to remove specific content from a chapter by css selector. (See Manual step 3 for more info)
   
   <b>Account support</b>: You can enter your account details for supported sites to download your unlocked VIP/Paid chapters.<br>
   
   You can add, remove and rearrange chapters manually via the Chapter Order window.
   
   ![alt text](https://i.imgur.com/wRVsHx8.png)

<strong>Manual:</strong>

<small>(if the novel is not on one of the supported sites)</small><br><br>
Using a Table of Content URL:</strong>
1. Enter the URL to the novel's "Table of Contents" page and retrieve all links on the site. 

2. Afterwards remove all unwanted links from the selection window. You can use shift/crtl-select like you normally would anywhere else. (Note: The chapters should be hosted on the same site or the chapter-text selectors will probably not work)<br>
![alt text](https://i.imgur.com/j9TbP0l.gif)

3. Input the chapter container wrapper the site uses. (Inspect a chapter page in your browser and look for something with which the container is identifiable. <br>
For example a `<div>` with a class `chapter-text` or id `chapter-content`. <br>
If you go with a class name, type a `.` in front of the name (`.chapter-text`) or a `#` for ids (`#chapter-content`). <br>
<small><a href="https://i.imgur.com/NGWjmUo.gif">(Showcase)</a></small><br>
You can find more complex selector examples and information on the official [jsoup site](https://jsoup.org/cookbook/extracting-data/selector-syntax).<br>

4. Specify potential blacklisted tags which you want removed and set metadata for the epub.

Using Chapter-To-Chapter navigation:
1. Input the URL of your starting point and ending point chapter. (Inclusive)
2. Input the selector for the "Next-Chapter" button. You want to select the `<a>` tag of it. Works exactly like the chapter-container selector of step 3.
3. Same as the other step 3.

<strong>CLI:</strong>

Usage:
[] = optional paramaters 
{} = arguments for paramater

| Parameter | Arguments | Description |
| :--- | :---: | :---|
-gui / `none` | | Starts the Graphical User Interface.
-link | {novel_URL} | URL to the novel's table of contents page. Starts download.
[-wait] | {miliseconds} | Time between each chapter grab.
[-headless] | {chrome/firefox/opera/edge/IE} | Visit the website in your browser. Executes javascript etc.
[-chapters] | {all}, {5 27}, {12 last}	| Specify which chapters to download.
[-path] | {directory_path} | Output directory for the EPUB.
[-account] | {username password} | Add a new account for the host.
[-login] | | Log in on website with saved account. -account is not needed if an account for this domain was added previously.
[-noDesc] | | Don't create a description page.
[-removeStyle] | | Remove all styling from chapter body.
[-getImages] | | Grab images from chapter body as well.
[-displayTitle]| | Write the chapter title at the top of each chapter text.
[-invertOrder] | | Invert the chapter order.
-help | | Shows the help page.

## Disclaimer & Warning
Most sites prohibit the scrapping for their content. Use at your own risk. 
Please use with appropriate wait times. Downloaded chapters are for private use only.

## Requirements
* [Java](https://www.java.com/en/) (version 8+) needs to be installed.

## Credits & Libraries 
Novel Grabber was build in java with: <br>
 * [jsoup](https://www.jsoup.org/)
 * [json-simple](https://code.google.com/archive/p/json-simple/)
 * [epublib](https://github.com/psiegman/epublib)
 * [webdrivermanager](https://github.com/bonigarcia/webdrivermanager)
 * [selenium ](https://selenium.dev/)
 * [Simple Java Mail ](https://github.com/bbottema/simple-java-mail/)
 
