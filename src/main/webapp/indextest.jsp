<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .wrap {
            border: 1px solid;
            display: flex; 
            overflow: hidden;
        }
        .wrap .rolling-list ul {
            padding : 0px;
            display: flex;
        }
        .wrap .rolling-list ul li { 
            box-sizing: border-box; 
            display: flex; 
            align-items: center; 
            flex-shrink: 0; 
        }
 
        .rolling-list.original {
            animation: rollingleft1 90s linear infinite;
        }
        .rolling-list.clone {
            animation: rollingleft2 90s linear infinite;
        }
 
        @keyframes rollingleft1 {
            0% { transform: translateX(0); }
            50% { transform: translateX(-100%); }
            50.01% { transform: translateX(100%); }
            100% { transform: translateX(0); }
        }
 
        @keyframes rollingleft2 {
            0% { transition: translateX(0); }
            100% { transform: translateX(-200%); }
        }
    </style>
</head>
<body>
    <div class="wrap"> <!-- 배너표시영역 -->
        <div class="rolling-list"> <!-- 원본배너 -->
            <ul>
                <li>
                    <a href="/member/modify"></a><div class="image-wrap"><img src="/img/2.jpg" alt=""></div>
                </li>
                <li>
                    <div class="image-wrap"><img src="/img/2_1.jpg" alt=""></div>
                </li>
                <li>
                    <div class="image-wrap"><img src="/img/2_2.jpg" alt=""></div>
                </li>
                <li>
                    <div class="image-wrap"><img src="/img/2_3.jpg" alt=""></div>
                </li>
            </ul>
        </div>
    </div>
    <script type="text/javascript">
        // 롤링 배너 복제본 생성
        let roller = document.querySelector('.rolling-list');
        roller.id = 'roller1'; // 아이디 부여
 
        let clone = roller.cloneNode(true)
        // cloneNode : 노드 복제. 기본값은 false. 자식 노드까지 복제를 원하면 true 사용
        clone.id = 'roller2';
        document.querySelector('.wrap').appendChild(clone); // wrap 하위 자식으로 부착
 
        document.querySelector('#roller1').style.left = '0px';
        document.querySelector('#roller2').style.left = document.querySelector('.rolling-list ul').offsetWidth + 'px';
        // offsetWidth : 요소의 크기 확인(margin을 제외한 padding값, border값까지 계산한 값)
 
        roller.classList.add('original');
        clone.classList.add('clone');
    </script>
</body>
</html>