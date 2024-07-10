<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form:form method="post" modelAttribute="p">
    <p>Ten phong: <form:input path="tenPhong"></form:input>
        <form:errors path="tenPhong"></form:errors>
    </p>
    <p>So luong: <form:input path="soLuongPhong"></form:input>
        <form:errors path="soLuongPhong"></form:errors></p>
    <p>Trang thai: <form:radiobutton path="trangThai" value="true"></form:radiobutton>Con phong
        <form:radiobutton path="trangThai" value="false"></form:radiobutton>Het phong</p>
    <p>Ghi chu: <form:input path="ghiChu"></form:input>
        <form:errors path="ghiChu"></form:errors></p>
    <p>Loai phong: <form:select path="idLoaiPhong" >
        <form:options items="${listLoaiPhong}" itemValue="id"></form:options>
    </form:select></p>
    <button formaction="/phong/add">Add</button>
    <button formaction="/phong/update/${idUpdate}">Update</button>
</form:form>

<table>
    <thead>
    <tr>
        <td>Ten phong</td>
        <td>So luong phong</td>
        <td>Trang thai</td>
        <td>Ghi chu</td>
        <td>Ten loai phong</td>
        <td>Hanh dong</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${phongs.content}" var="p" varStatus="i">
        <tr>
            <td>${p.tenPhong}</td>
            <td>${p.soLuongPhong}</td>
            <td>${p.trangThai}</td>
            <td>${p.ghiChu}</td>
            <td>${loaiPhongMap[p.idLoaiPhong]}</td>
            <td>
                <a href="/phong/${p.id}?page=${phongs.number}">Detail</a>
                <a href="/phong/update/${p.id}?page=${phongs.number}">Update</a>
                <a href="/phong/delete/${p.id}?page=${phongs.number}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/phong?page=${phongs.number-1 < 0 ? 0 : phongs.number-1}">Pre</a>
<c:forEach begin="0" end="${phongs.totalPages-1}" var="i">
    <a href="/phong?page=${i}">${i+1}</a>
</c:forEach>
<a href="/phong?page=${phongs.number +1}">Nex</a>

