<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@page import="okcode.biz.trading.enums.Module" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div id="breadcrumb">
	<a href="${ctx}/console/home"><i class="icon-home"></i> 首页</a>
	<a href="#"><i class="icon-th-list"></i> 栏目规划</a>
	<a class="current" href="#">栏目设置</a>	
</div>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon">
					<i class="icon-th-list"></i>
					</span>
					<h5>栏目设置</h5>
				</div>
				<div class="widget-content">
					<div class="row-fluid">
						<div class="span12">
							
							<c:if test="${!empty catalogItems}">
							<table class="table table-bordered table-striped table-hover">
								<tr>
									<th width="40px">排序</th>
									<th>栏目名称 (<a href="javascript:;" onclick="$('.a-show-icon').trigger('click');">全显</a>,<a href="javascript:;" onclick="$('.a-hide-icon').trigger('click');">收起</a>)</th>
									<th width="120px">导航栏显示</th>
									<th width="120px">模块类型</th>
									<th>访问别名</th>
									<th width="160px">操作</th>
								</tr>
								
								<c:forEach items="${catalogItems}" var="firstItem">
								<tr>
									<td><input type="text" class="ipt-rank" value="${firstItem.catalog.rank}"/></td>
									<td class="text-align-left">
										<c:if test="${!empty firstItem.subCatalog}">
											<a href="javascript:;" class="a-show-${firstItem.catalog.id} a-show-icon" onclick="
												$('.tr-${firstItem.catalog.id}').show(500);
												$('.a-show-${firstItem.catalog.id}').hide();
												$('.a-hide-${firstItem.catalog.id}').show();
												"><i class="icon-plus-sign"></i></a>
											<a href="javascript:;" class="a-hide-${firstItem.catalog.id} a-hide-icon" style="display: none;" onclick="
												$('.tr-${firstItem.catalog.id} .a-hide-icon').trigger('click');
												$('.tr-${firstItem.catalog.id}').hide(500);
												$('.a-hide-${firstItem.catalog.id}').hide();
												$('.a-show-${firstItem.catalog.id}').show();
												"><i class="icon-minus-sign"></i></a>
											 <span> ${firstItem.catalog.title}</span>
										</c:if>
										<c:if test="${empty  firstItem.subCatalog}">
											<span style="padding-left: 18px;"> ${firstItem.catalog.title}</span>
										</c:if>
									</td>
									<td>${firstItem.catalog.navDisplay.label}</td>
									<td>${firstItem.catalog.module.label}</td>
									<td>${firstItem.catalog.alias}</td>
									<td class="text-align-left">
									    <div class="btn-group">
									    <a class="btn btn-small" href="${ctx}/console/columnConfig/modify?cid=${firstItem.catalog.id}">修改</a>
									    <c:if test="${(firstItem.catalog.module != 'sitemap')&&(firstItem.catalog.module != 'search')&&(firstItem.catalog.module != 'outlink')}">
									    <a class="btn btn-small" href="#myModal" data-toggle="modal" onclick="$('#module option[value=${firstItem.catalog.module}]').attr('selected',true);$('#pid').val('${firstItem.catalog.id}');" >添加子栏目</a>
									    </c:if>
									    <button class="btn btn-danger btn-small btn-del-${firstItem.catalog.id}" onclick="doDelete(${firstItem.catalog.id});">删除</button>
									    </div>
									</td>
								</tr>
								
								<c:if test="${!empty firstItem.subCatalog}">
									<c:forEach items="${firstItem.subCatalog}" var="secondItem" varStatus="sst">
									<tr class="tr-${firstItem.catalog.id}" style="display: none;">
										<td><input type="text" class="ipt-rank" value="${secondItem.catalog.rank}"/></td>
										<td class="text-align-left" style="padding-left:30px;">
										└ <c:if test="${!empty secondItem.subCatalog}">
												<a href="javascript:;" class="a-show-${secondItem.catalog.id} a-show-icon" onclick="
													$('.tr-${secondItem.catalog.id}').show(500);
													$('.a-show-${secondItem.catalog.id}').hide();
													$('.a-hide-${secondItem.catalog.id}').show();
													"><i class="icon-plus-sign"></i></a>
												<a href="javascript:;" class="a-hide-${secondItem.catalog.id} a-hide-icon" style="display: none;" onclick="
													$('.tr-${secondItem.catalog.id}').hide(500);
													$('.a-hide-${secondItem.catalog.id}').hide();
													$('.a-show-${secondItem.catalog.id}').show();
													"><i class="icon-minus-sign"></i></a>
												 <span> ${secondItem.catalog.title}</span>
											</c:if>
											<c:if test="${empty secondItem.subCatalog}">
												<span style="padding-left: 18px;"> ${secondItem.catalog.title}</span>
											</c:if>
										</td>
										<td>${secondItem.catalog.navDisplay.label}</td>
										<td>${secondItem.catalog.module.label}</td>
										<td>${secondItem.catalog.alias}</td>
										<td class="text-align-left">
										    <div class="btn-group">
										    <a class="btn btn-small" href="${ctx}/console/columnConfig/modify?cid=${secondItem.catalog.id}">修改</a>
										    <c:if test="${(secondItem.catalog.module != 'sitemap') && (secondItem.catalog.module != 'search') && (secondItem.catalog.module != 'outlink')}">
										    <a class="btn btn-small" href="#myModal" data-toggle="modal" onclick="$('#module option[value=${secondItem.catalog.module}]').attr('selected',true);$('#pid').val('${secondItem.catalog.id}');" >添加子栏目</a>
										    </c:if>
										    <button class="btn btn-danger btn-small btn-del-${secondItem.catalog.id}" onclick="doDelete(${secondItem.catalog.id});">删除</button>
										    </div>
										</td>
									</tr>
									
									<c:if test="${!empty secondItem.subCatalog}">
										<c:forEach items="${secondItem.subCatalog}" var="thirdItem" varStatus="tst">
										<tr class="tr-${secondItem.catalog.id}" style="display: none;">
											<td><input type="text" class="ipt-rank" value="${thirdItem.catalog.rank}"/></td>
											<td class="text-align-left" style="padding-left:65px;">
											└ <span> ${thirdItem.catalog.title}</span>
											</td>
											<td>${thirdItem.catalog.navDisplay.label}</td>
											<td>${thirdItem.catalog.module.label}</td>
											<td>${thirdItem.catalog.alias}</td>
											<td class="text-align-left">
											    <div class="btn-group">
											    <a class="btn btn-small" href="${ctx}/console/columnConfig/modify?cid=${thirdItem.catalog.id}">修改</a>
											    <button class="btn btn-danger btn-small btn-del-${thirdItem.catalog.id}" onclick="doDelete(${thirdItem.catalog.id});">删除</button>
											    </div>
											</td>
										</tr>
										</c:forEach>
									</c:if>
									</c:forEach>
								</c:if>
								</c:forEach >
							</table>
							</c:if>
							<c:if test="${empty catalogItems}">
								您还没有栏目哦，
							</c:if>
							<a class="btn btn-primary btn-small" href="#myModal" data-toggle="modal" onclick="$('#pid').val('')">添加栏目</a>
						</div>
					</div>
				</div>
			</div>					
		</div>
	</div>
</div>
<div class="modal fade" id="myModal">
	<div class="modal-header">
		<a class="close" data-dismiss="modal">×</a>
		<h3>您要添加那种模块类型的栏目?</h3>
	</div>
	<div class="modal-body">
		<select id="module">
			<% for (Module m : Module.values()) { %>
			<option value="<%=m.toString()%>"><%=m.getLabel()%></option>
			<% } %>
		</select>
		<input type="hidden" id="pid" value="" />
	</div>
	<div class="modal-footer">
		<a class="btn" data-dismiss="modal">关闭</a>
		<a href="javascript:;" class="btn btn-primary" onclick="window.location.href='${ctx}/console/columnConfig/add?module='+$('#module').val()+'&pid='+$('#pid').val()">确定</a>
	</div>
</div>
<script type="text/javascript">
function doDelete(cid) {
	$.ajax2({
		url : "${ctx}/console/columnConfig/doDelete",
		data : {cid:cid},
		btn : '.btn-del-'+cid,
		success : function(result) {
			if (result.code == 0) {
				setTimeout(function() {
					window.location.href='${ctx}/console/columnConfig';
				},1000);
			}
		}
	});
}
$(function() {
	$('.a-show-icon').trigger('click');
});
</script>