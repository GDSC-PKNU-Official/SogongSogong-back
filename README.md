<div align="center">
  
[![Contributors][contributors-shield]][contributors-url] [![Forks][forks-shield]][forks-url] [![Stargazers][stars-shield]][stars-url] [![Issues][issues-shield]][issues-url]
  

<br>
<a href="https://github.com/othneildrew/Best-README-Template">
<img src="https://i.imgur.com/NbY0NQh.png" alt="Logo" width="30%">
</a>

<strong>Sogong Sogong (소공소공)</strong><br>
Anonymous Communication Platform for Small Business
to solve the UN's SDGS No.8.<br><br>
<a href="https://treejin99.notion.site/_-b293dc72cc5b472e90edf3fc707f24dc"><strong>Explore the notion (Only In Korean)</strong></a><br>
<a href="">View Demo</a> · <a href="https://github.com/GDSC-PKNU-21-22/SogongSogong-front/issues">Report Bug & Request Feature</a> · <a href="https://github.com/GDSC-PKNU-21-22/SogongSogong-front/blob/develop/README.md">Front-End Readme</a>

</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
      <li><a href="#Introduction">Introduction</a></li>
      <li><a href="#tech">Tech Stack(Back-End)</a></li>    
      <li><a href="#Prerequisites">Prerequisites</a></li>
      <li><a href="#Back-End-Structure">Back-End Structure</a></li>
      <ul>
          <li><a href = "#ERD">ERD</a></li>
          <li><a href = "#Directory">Directory</a></li>
      </ul>
  </ol>
</details>

***

## Introduction
**This is Back-End readme page about *Sogong Sogong* Project.**
      
If you want to see details about service, please enter the link down below.
<br><a href = "https://github.com/GDSC-PKNU-21-22/SogongSogong-front/blob/develop/README.md">SogongSogong-Front Readme.md</a>


<h3 id="tech"> Tech Stack(Back-End) </h3>

<img src="https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white"><img src="https://img.shields.io/badge/kotlin-%230095D5.svg?style=for-the-badge&logo=kotlin&logoColor=white"><img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"><img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"><img src="https://img.shields.io/badge/GoogleCloud-%234285F4.svg?style=for-the-badge&logo=google-cloud&logoColor=white">

***
## Prerequisites

#### To edit file, you need to install ...
- Latest version of IntelliJ IDEA
- Kotlin 1.6.10
- Spring Boot 2.6.3
- MySQL 8.0


***


## Back-End Structure
### ERD
(코드 정리 후 올릴 예정)<br>
Detail description about DB, see <a href="#er">this part</a>.

### Directory
```
Main sources are placed to 'SogongSogong-back/src/main/kotlin/sogong/sogongSpring'.
```
#### 1. Controller
- There are three controllers, which named **'BoardController'**, **'HastagContorller'** and **'UserController'**.<br>
- 'BoardController' is about board CRUD controller.<br>
- We designed as REST api and also conformed RESTful as much as possible.
#### 2. DTO
- DTOs created which need to send input and output to client.<br>
- Used less DTOs than Entities because it's still under development.<br>
I will add it soon.

<h4 id="er"> 3. Entity, Repository </h4>

- **EntirePost** : Information about post writing.<br>
- **EntireComment** : Information about comment writing.  <br>
- **ScrapLike** : Information about clippings and liked of one post that other users saved.<br>
- **HashtagDb** : Information about types of hashtag.<br>
- **PostHashtag** : Information about hashtags of one post that user wrote.<br>
- **UserHashtag** : Information about hashtags of 'Hastag Board' that user designated and saved.<br>

#### 4. Service
- I seperated it according to controller detailed functions.<br>
- **Board** : Saving service about board.<br>
It includes save not only boards but also comments, clippings, liked.<br>
- **BoardEdit** : Editing Service about board.<br>
The things to edit are same as Board Service.<br>
- **BoardPrint** : Printing service about board.<br>
The things to print are same as Board Service and 'Hot Post', 'Best Post' also included.<br>
- **Hastag** : CRUD service about hashtag.
- **User** : Auth service about inqure into business license number through external API.<br>
Verifying business license is only available on Korea, other countries will support soon.<br>
Details about external API that I used can be seen in <a href= "https://www.data.go.kr/data/15081808/openapi.do">this link.</a>
- **CustomException** : Class about custom exceptions that handle easier.
      
***
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create.  
Any contributions you make are **greatly appreciated**.

1. <a href="https://github.com/GDSC-PKNU-21-22/SogongSogong-back/issues">Request Feature yourself</a>
2. Fork the Project
3. Create your Feature Branch (`git checkout -b feature/#{IssueNumber}`) 
    - `ex) feature/#1`
5. Commit your Changes (`git commit -m 'Issue #{IssueNumber} feat: Add some AmazingFeature'`)
6. Push to the Branch (`git push origin feature/#{IssueNumber}`)
7. Open a Pull Request

***

[![contributors][contributors-shield]][contributors-url] [![forks][forks-shield]][forks-url] [![stars][stars-shield]][stars-url] [![issues][issues-shield]][issues-url]


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[contributors-shield]: https://img.shields.io/github/contributors/GDSC-PKNU-21-22/SogongSogong-back.svg?style=for-the-badge
[contributors-url]: https://github.com/GDSC-PKNU-21-22/SogongSogong-back/graphs/contributors

[forks-shield]: https://img.shields.io/github/forks/GDSC-PKNU-21-22/SogongSogong-back.svg?style=for-the-badge
[forks-url]: https://github.com/GDSC-PKNU-21-22/SogongSogong-back/network/members

[stars-shield]: https://img.shields.io/github/stars/GDSC-PKNU-21-22/SogongSogong-back.svg?style=for-the-badge
[stars-url]: https://github.com/GDSC-PKNU-21-22/SogongSogong-back/stargazers

[issues-shield]: https://img.shields.io/github/issues/GDSC-PKNU-21-22/SogongSogong-back.svg?style=for-the-badge
[issues-url]: https://github.com/GDSC-PKNU-21-22/SogongSogong-back/issues
