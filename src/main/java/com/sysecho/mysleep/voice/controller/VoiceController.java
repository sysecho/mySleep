package com.sysecho.mysleep.voice.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.gridfs.GridFSDBFile;
import com.sysecho.mysleep.response.ResponseCode;
import com.sysecho.mysleep.response.ResponseData;
import com.sysecho.mysleep.voice.entity.Voice;
import com.sysecho.mysleep.voice.service.VoiceService;

@Controller
@RequestMapping("voice")
public class VoiceController {

	@Autowired
	private VoiceService voiceService;

	@Autowired
	private GridFsTemplate gridFsTemplate;

	@RequestMapping("voices")
	public @ResponseBody ResponseData voices(int pageNo, int pageSize) {
		Page<Voice> page = voiceService.findByPage(pageNo, pageSize);
		return new ResponseData(true, "请求成功", ResponseCode.success, page.getResult(),
				new Integer(String.valueOf(page.getTotal())));
	}

	@RequestMapping("remove")
	public @ResponseBody ResponseData remove(Integer id) {
		Voice voice = voiceService.selectByPrimaryKey(id);
		gridFsTemplate.delete(new Query(Criteria.where("_id").is(voice.getObjectId())));
		this.voiceService.deleteByPrimaryKey(id);
		return new ResponseData(true, "删除成功", ResponseCode.success);
	}

	@RequestMapping("upload")
	public @ResponseBody Object upload(@RequestParam("file") MultipartFile file) throws IOException {
		if (null == file || file.getSize() > 0) {
			ObjectId store = gridFsTemplate.store(file.getInputStream(), file.getOriginalFilename(),
					file.getContentType());
			if (null != store) {
				Voice voice = new Voice();
				voice.setName(file.getOriginalFilename());
				voice.setContentType(file.getContentType());
				voice.setImageUrl("");
				voice.setObjectId(String.valueOf(store));
				voice.setCreatedDate(new Date());
				voice.setSize(new BigDecimal(file.getSize()));
				voiceService.insert(voice);
				return new ResponseData(true, "请求成功！", ResponseCode.success);
			} else {
				return new ResponseData(false, "文件上传失败！", ResponseCode.success);
			}
		} else {
			return new ResponseData(false, "文件不能为空", ResponseCode.success);
		}
	}

	@RequestMapping("download")
	public void downFile(HttpServletResponse response, Integer id) throws Exception {
		Voice voice = voiceService.selectByPrimaryKey(id);
		GridFSFile gridFSFile = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(voice.getObjectId())));
		response.setContentType("application/octet-stream");
		// 设置下载文件名
		response.addHeader("Content-Disposition", "attachment; filename=\""
				+ URLEncoder.encode(voice.getName(), StandardCharsets.UTF_8.toString()) + "\"");
		IOUtils.copy(null, response.getOutputStream());
	}
}
