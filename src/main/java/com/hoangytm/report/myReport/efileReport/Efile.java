package com.hoangytm.report.myReport.efileReport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author PhanHoang
 * 12/11/2020
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "EFILE")
public class Efile implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name = "ID", nullable = false, length = 100)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name = "PROCEDURE_ID", length = 100)
    private Long procedureId;

    @Column(name = "TITLE", length = 250)
    private String title;

    @Column(name = "CODE", length = 100)
    private String code;

    @Column(name = "SENDER_NAME", length = 350)
    private String senderName;

    @Column(name = "SENDER_CODE", length = 100)
    private String senderCode;

    @Column(name = "SENDER_CODE_TYPE")
    private Long senderCodeType;

    @Column(name = "SENDER_ADDRESS", length = 350)
    private String senderAddress;

    @Column(name = "SENDER_EMAIL", length = 150)
    private String senderEmail;

    @Column(name = "SENDER_TEL", length = 100)
    private String senderTel;

    @Column(name = "SENDER_IS_OWNER")
    private Long senderIsOwner;

    @Column(name = "SENDER_PROVINCE_ID", length = 100)
    private String senderProvinceId;

    @Column(name = "SENDER_PROVINCE_NAME", length = 250)
    private String senderProvinceName;

    @Column(name = "SENDER_DISTRICT_ID", length = 100)
    private String senderDistrictId;

    @Column(name = "SENDER_DISTRICT_NAME", length = 250)
    private String senderDistrictName;

    @Column(name = "SENDER_COMMUNE_ID", length = 100)
    private String senderCommuneId;

    @Column(name = "SENDER_COMMUNE_NAME", length = 250)
    private String senderCommuneName;

    @Column(name = "OWNER_TYPE")
    private Long ownerType;

    @Column(name = "OWNER_NAME", length = 250)
    private String ownerName;

    @Column(name = "OWNER_ADDRESS", length = 350)
    private String ownerAddress;

    @Column(name = "OWNER_EMAIL", length = 150)
    private String ownerEmail;

    @Column(name = "OWNER_TEL", length = 100)
    private String ownerTel;

    @Column(name = "OWNER_PROVINCE_ID", length = 100)
    private String ownerProvinceId;

    @Column(name = "OWNER_PROVINCE_NAME", length = 250)
    private String ownerProvinceName;

    @Column(name = "OWNER_DISTRICT_ID", length = 100)
    private String ownerDistrictId;

    @Column(name = "OWNER_DISTRICT_NAME", length = 250)
    private String ownerDistrictName;

    @Column(name = "OWNER_COMMUNE_ID", length = 100)
    private String ownerCommuneId;

    @Column(name = "OWNER_COMMUNE_NAME", length = 250)
    private String ownerCommuneName;

    @Column(name = "PROCEDURE_CODE", length = 100)
    private String procedureCode;

    @Column(name = "NOTE", length = 350)
    private String note;

    @Column(name = "STATUS_ID", length = 100)
    private String statusId;

    @Column(name = "STATUS_NAME", length = 250)
    private String statusName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SEND_TIME")
    private Date sendTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RECEIPT_TIME")
    private Date receiptTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PROMISE_TIME")
    private Date promiseTime;

    @Column(name = "RECEIVE_TYPE")
    private Long receiveType;

    @Column(name = "BAR_CODE", length = 500)
    private String barCode;

    @Column(name = "DEADLINE_DAY")
    private Long deadlineDay;

    @Column(name = "RECEIVE_SERVICE_ID")
    private Long receiveServiceId;

    @Column(name = "RECEIVE_SERVICE_NAME", length = 250)
    private String receiveServiceName;

    @Column(name = "RECEIVE_ADDRESS", length = 350)
    private String receiveAddress;

    @Column(name = "RECEIVE_TEL", length = 100)
    private String receiveTel;

    @Column(name = "RECEIVE_POST_ID", length = 100)
    private String receivePostId;

    @Column(name = "RECEIVE_POST_NAME", length = 250)
    private String receivePostName;

    @Column(name = "IS_ACTIVE")
    private Long isActive;

    @Column(name = "IS_DELETE")
    private Long isDelete;

    @Column(name = "ADDITION1", length = 350)
    private String addition1;

    @Column(name = "ADDITION2", length = 350)
    private String addition2;

    @Column(name = "ADDITION3", length = 350)
    private String addition3;

    @Column(name = "ADDITION4", length = 350)
    private String addition4;

    @Column(name = "ADDITION5", length = 350)
    private String addition5;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "USER_CREATE_ID")
    private Long userCreateId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    @Column(name = "USER_UPDATE_ID")
    private Long userUpdateId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EXTEND_TIME")
    private Date extendTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RELEASE_TIME")
    private Date releaseTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FINISH_TIME")
    private Date finishTime;

    @Column(name = "SUB_STATUS_ID", length = 100)
    private String subStatusId;

    @Column(name = "SUB_STATUS_NAME", length = 250)
    private String subStatusName;

    @Column(name = "BOOK_NUMBER", length = 100)
    private String bookNumber;

    @Column(name = "OWNER_CODE", length = 100)
    private String ownerCode;

    @Column(name = "DEPT_ID")
    private Long deptId;

    @Column(name = "DEPT_NAME", length = 100)
    private String deptName;

    @Column(name = "BAR_CODE_ATTACHMENT_ID")
    private Long barCodeAttachmentId;

    @JsonIgnore
    @Column(name = "TYPE")
    private Long type;

}