package com.brainvire.mvvm_clean_arch.domain.repository

import com.brainvire.mvvm_clean_arch.data.model.request.ReqDirectOrderDashboard
import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.brainvire.mvvm_clean_arch.data.model.response.direct_order.dashboard.Data

interface DirectOrderRepository {
    suspend fun directOrderDashboard(model: ReqDirectOrderDashboard): Resource<AppResponse<List<Data>>>
   /* suspend fun directOrderList(model: ReqDirectOrderList): Resource<AppResponse<RespDirectOrderList>>
    suspend fun directOrderDetails(id: Int?): Resource<AppResponse<RespDirectOrderDetails>>
    suspend fun directOrderAcceptOrder(model: ReqDirectOrderAcceptOrder, id: Int?): Resource<AppResponse<RespDirectOrderAcceptOrder>>
    suspend fun directOrderRejectOrder(model: ReqDirectOrderRejectOrder, id: Int?): Resource<AppResponse<RespDirectOrderAcceptOrder>>
    suspend fun driverTruckDetails(id: Int): Resource<AppResponse<RespDriverTruckDetails>>
    suspend fun tripDetails(id: Int?): Resource<AppResponse<RespTripDetails>>
    suspend fun addDriverTruck(model: ReqAddDriverTruck, id: Int): Resource<AppResponse<Any>>
    suspend fun directOrderInvoice(model: ReqDirectOrderInvoice): Resource<AppResponse<RespInvoice>>
    suspend fun editDriverTruck(model: ReqAddDriverTruck, id: Int): Resource<AppResponse<Any>>
    suspend fun vehicleList(tripId: Int?): Resource<AppResponse<List<Vehicle>>>
    suspend fun driverList(): Resource<AppResponse<List<Driver>>>
    suspend fun tripStatus(): Resource<AppResponse<List<com.shahen.provider.core.models.responses.direct_order.trip_details.Data>>>
    suspend fun changeTripStatus(tripId: Int?, model: ReqChangeStatus): Resource<AppResponse<Any>>
    suspend fun orderStatus(model: ReqOrderStatus): Resource<AppResponse<List<com.shahen.provider.core.models.responses.direct_order.trip_details.Data>>>
    suspend fun changeOrderStatus(orderId: Int?, model: ReqChangeStatus): Resource<AppResponse<Any>>
    suspend fun shipmentType(): Resource<AppResponse<RespShipmentType>>
    suspend fun goodsType(): Resource<AppResponse<RespGoodsType>>
    suspend fun wayBillAndBayanDownload(orderId: Int, model: ReqWaybillAndBayan): Resource<AppResponse<RespWayBillAndBayanDownload>>
    suspend fun contractOrderList(model: ReqDirectOrderList): Resource<AppResponse<RespDirectOrderList>>*/
}
