# 소공소공, Sogong Sogong

<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/othneildrew/Best-README-Template">
    <img src="https://i.imgur.com/NbY0NQh.png" alt="Logo" width="30%" height="30%">
  </a>
  <p align="center">
</p>

:::info  
**Sogong Sogong** is our team's idea to find the answer to "how" to grow as a small business communication channel to solve the  UN's SDGS No.8. 
:::
  
    
<a href="https://treejin99.notion.site/_-b293dc72cc5b472e90edf3fc707f24dc"><strong>Explore the notion (Only In Korean)</strong></a>
    <a href="">View Demo</a>
    <a href="https://github.com/GDSC-PKNU-21-22/SogongSogong-back/issues">Report Bug & Request Feature</a>
      
<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
      <li><a href="#Introduction">Introduction</a></li>
      <li><a href="#Tech-Stack">Tech Stack</a></li>    
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
      
If you want to see details about service, Please enter the link down below.
<a href = "">여기는 프론트 readme 링크~~</a>


### Tech Stack

- <b>BackEnd</b>
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
(코드 정리 후 올릴 예정)
Detail description about DB, see <a href="#3.-Entity,-Repository">this part</a>.

### Directory
```
Main sources are placed to 'SogongSogong-back/src/main/kotlin/sogong/sogongSpring'.
```
#### 1. Controller
- There are three controllers, which named **'BoardController'**, **'HastagContorller'** and **'UserController'**.
- 'BoardController' is about board CRUD controller.
- We designed as REST api and also conformed RESTful as much as possible.
#### 2. DTO
- DTOs created which need to send input and output to client.
- Used less DTOs than Entities because it's still under development.
I will add it soon.
#### 3. Entity, Repository
- **EntirePost** : Information about post writing.
- **EntireComment** : Information about comment writing.  
- **ScrapLike** : Information about clippings and liked of one post that other users saved.
- **HashtagDb** : Information about types of hashtag.
- **PostHashtag** : Information about hashtags of one post that user wrote.
- *UserHashtag** : Information about hashtags of 'Hastag Board' that user designated and saved.
#### 4. Service
- I seperated it according to controller detailed functions.
- **Board** : Saving service about board.
It includes save not only boards but also comments, clippings, liked.
- **BoardEdit** : Editing Service about board.
The things to edit are same as Board Service.
- **BoardPrint** : Printing service about board.
The things to print are same as Board Service and 'Hot Post', 'Best Post' also included.
- **Hastag** : CRUD service about hashtag.
- **User** : Auth service about inqure into business license number through external API.
Verifying business license is only available on Korea, other countries will support soon.
Details about external API that I used can be seen in <a href= "https://www.data.go.kr/data/15081808/openapi.do">this link.</a>
- **CustomException** : Class about custom exceptions that handle easier.
      
***
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

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
