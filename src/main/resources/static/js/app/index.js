var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });

        $('#btn-reply-save').on('click',function (){
            _this.replySave();
        });

        $('#btn-reply-update').on('click',function (){
            _this.replyUpdate();
        });

        $('#btn-scrap').on('click',function(){
            _this.scrapSave();
        });

    },
    save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };
        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        var id = $('#id').val();
const con_check = confirm("글을 삭제하시겠습니까?");

if (con_check===true){
        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
    },

    replySave : function () {

            var id = $('#postsId').val();

            var data = {
            postsId: $('#postsId').val(),
            comment: $('#comment').val()
            };

            $.ajax({
                type: 'POST',
                url: '/api/v1/posts/'+ id +'/reply',
                contentType:'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function() {
                alert('댓글이 등록되었습니다.');
                window.location.reload();
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        },

        replyUpdate : function () {
                var data = {
                    comment: $('#comment').val()
                };

                var commentId = $('#commentId').val();

                $.ajax({
                    type: 'PUT',
                    url: '/api/v1/reply/' + commentId,
                    dataType: 'json',
                    contentType:'application/json; charset=utf-8',
                    data: JSON.stringify(data)
                }).done(function() {
                    alert('댓글이 수정되었습니다.');
                    window.location.href = '/';
                }).fail(function (error) {
                    alert(JSON.stringify(error));
                });
            },

    replyDelete : function (postsId,commentId) {
            const con_check = confirm("삭제하시겠습니까?");
         if (con_check===true){
            $.ajax({
                type: 'DELETE',
                url: '/api/v1/posts/'+ postsId +'/reply/' + commentId,
            }).done(function() {
                alert('댓글이 삭제되었습니다.');
                window.location.reload();
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
            }
        },

    scrapSave : function () {
                var data = {
                postsId:$('#id').val(),
                title: $('#title').val(),
                };

                $.ajax({
                    type: 'POST',
                    url: '/api/v1/scrap/',
                    contentType:'application/json; charset=utf-8',
                    data: JSON.stringify(data)
                }).done(function() {
                    alert('스크랩되었습니다.');
                    window.location.reload();
                }).fail(function (error) {
                    alert(JSON.stringify(error));
                });

    },

    scrapDelete :function(id){
       const con_check = confirm("스크랩을 삭제하시겠습니까?");
             if (con_check===true){
                $.ajax({
                    type: 'DELETE',
                    url: '/api/v1/posts/scrap/'+id,
                }).done(function() {
                    alert('스크랩이 삭제되었습니다.');
                    window.location.reload();
                }).fail(function (error) {
                    alert(JSON.stringify(error));
                });
                }
    },

    calCircle:function(intAllSt,intAllRow){
        var a = $('#intAllSt').val();
        var b = $('#intAllRow').val();

        var resultIntSt = Number(a)-Number(b*6);

        alert('떠야 할 시작코는 '+resultIntSt+'코 입니다.');

    },

    calEllipse:function(intSt,intAllRow){
        var c = $('#intSt').val();
        var d = $('#intAllRow').val();
        var resultIntSt = Number(c)+Number(d*6);

        alert('떠야 할 총 코수는 '+resultIntSt+'코 입니다.');
    }

};

main.init();