<%--<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>--%>
<%--    <title>댓글</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div>--%>
<%--    <a href="./boardList.do?pageNum=<%=page%>" class="btn btn-primary">목록</a>--%>
<%--</div>--%>
<%--<hr>--%>
<%--<!--리플 시작-->--%>
<%--<c:if test="${sessionMemberId != null}">--%>
<%--    <form name="frmRipple" method="post">--%>
<%--        <input type="hidden" name="num" value="${board.num}"> <!--게시물의 키-->--%>
<%--        <div class="form-group-row">--%>
<%--            <div class="col-sm-3">--%>
<%--                <input name="name" type="text" class="form-control" value="${sessionMemberName}" placeholder="name">--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="form-group-row">--%>
<%--            <div class="col-sm-8">--%>
<%--                <textarea name="content" class="form-control" cols="50" rows="3"></textarea>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="form-group row">--%>
<%--            <div class="col-sm-4">--%>
<%--                <span class="btn btn-primary" id="goRippleSubmit">등록</span>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </form>--%>
<%--    <script>--%>
<%--        document.addEventListener('DOMContentLoaded', function (){--%>
<%--            const xhr = new XMLHttpRequest(); //ajax 작업을 위한 객체 생성--%>
<%--            const btnRippleSubmit = document.querySelector('#goRippleSubmit'); //리플 등록 버튼--%>
<%--            const frmRipple = document.querySelector('form[name=frmRipple]');--%>

<%--            btnRippleSubmit.addEventListener('click', function (){ /*등록버튼 클릭시*/--%>
<%--                /*form 안에 input 태그가 있지만 form을 submit하는 것이 아니라 ajax로 값을 넘겨야 되어서 값을 추출 함*/--%>
<%--                const num = frmRipple.num.value;--%>
<%--                const name = frmRipple.name.value;--%>
<%--                const content = frmRipple.content.value;--%>

<%--                xhr.open('POST', '/ripple/add?num=' + num + '$name=' + name + '$content' + content);--%>
<%--                xhr.send();--%>
<%--                xhr.onreadystatechange = () => {--%>
<%--                    if(xhr.readyState !== XMLHttpRequest.DONE)--%>
<%--                        return;--%>

<%--                    if (xhr.status === 200){--%>
<%--                        console.log(xhr.response);--%>
<%--                        const json = JSON.parse(xhr.response); //response에 있는 JSON 문자열을 json 객체로 변환--%>
<%--                        if(json.result === 'true'){--%>
<%--                            frmRipple.content.value = ''; //등록이 성공했으니 내용에 입력한 내용을 지움--%>
<%--                        } else {--%>
<%--                            alert('등록에 실패하였습니다.');--%>
<%--                        }--%>
<%--                    } else {--%>
<%--                        console.error(xhr.status, xhr.statusText);--%>
<%--                    }--%>
<%--                }--%>

<%--            })--%>
<%--        });--%>
<%--    </script>--%>
<%--</c:if>--%>
<%--<!--// 리플 끝-->--%>
<%--&lt;%&ndash;<div class="form-group row">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <label class="col-sm-2 control-label">내용</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <div class="col-sm-8" style="">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <%=ripple.content()%>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </div>&ndash;%&gt;--%>

<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--</body>--%>
<%--</html>--%>
