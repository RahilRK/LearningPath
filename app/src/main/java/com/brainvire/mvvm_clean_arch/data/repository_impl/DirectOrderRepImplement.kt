package com.brainvire.mvvm_clean_arch.data.repository_impl

import com.brainvire.mvvm_clean_arch.data.local.PreferenceManager
import com.brainvire.mvvm_clean_arch.data.model.request.ReqDirectOrderDashboard
import com.brainvire.mvvm_clean_arch.data.model.response.AppResponse
import com.brainvire.mvvm_clean_arch.data.model.response.Resource
import com.brainvire.mvvm_clean_arch.data.model.response.direct_order.dashboard.Data
import com.brainvire.mvvm_clean_arch.data.remote.ApiInterface
import com.brainvire.mvvm_clean_arch.di.makeAPICall
import com.brainvire.mvvm_clean_arch.domain.repository.DirectOrderRepository
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DirectOrderRepImplement @Inject constructor(
    private val apiInterface: ApiInterface,
    private val preferenceManager: PreferenceManager,
    private val gson: Gson
) : DirectOrderRepository {
    override suspend fun directOrderDashboard(model: ReqDirectOrderDashboard): Resource<AppResponse<List<Data>>> {
        val response = makeAPICall(gson) {
            apiInterface.directOrderDashboard(model)
        }
        return response
    }

/*    override suspend fun directOrderList(model: ReqDirectOrderList): Resource<AppResponse<RespDirectOrderList>> {
        val response = if(model.section == Constants.SECTION_DIRECT_ORDER) {
            makeAPICall(gson) {
                directOrderAPI.directOrderList(model)
            }
        }
        else {
            makeAPICall(gson) {
                specialOrderAPI.specialOrderList(model)
            }
        }
        return response
    }

    override suspend fun directOrderDetails(id: Int?): Resource<AppResponse<RespDirectOrderDetails>> {
        val response = makeAPICall(gson) {
            directOrderAPI.directOrderDetails(id)
        }
        return response
    }

    override suspend fun directOrderAcceptOrder(model: ReqDirectOrderAcceptOrder, id: Int?): Resource<AppResponse<RespDirectOrderAcceptOrder>> {
        val response = makeAPICall(gson) {
            directOrderAPI.directOrderAcceptOrder(id, model)
        }
        return response
    }

    override suspend fun directOrderRejectOrder(model: ReqDirectOrderRejectOrder, id: Int?): Resource<AppResponse<RespDirectOrderAcceptOrder>> {
        val response = makeAPICall(gson) {
            directOrderAPI.directOrderRejectOrder(id, model)
        }
        return response
    }

    override suspend fun driverTruckDetails(id: Int): Resource<AppResponse<RespDriverTruckDetails>> {
        val response = makeAPICall(gson) {
            directOrderAPI.driverTruckDetails(id)
        }
        return response
    }

    override suspend fun tripDetails(id: Int?): Resource<AppResponse<RespTripDetails>> {
        val response = makeAPICall(gson) {
            directOrderAPI.tripDetails(id)
        }
        return response
    }

    override suspend fun addDriverTruck(model: ReqAddDriverTruck, id: Int): Resource<AppResponse<Any>> {
        val response = makeAPICall(gson) {
            directOrderAPI.addDriverTruck(id, model)
        }
        return response
    }

    override suspend fun directOrderInvoice(model: ReqDirectOrderInvoice): Resource<AppResponse<RespInvoice>> {
        val response = makeAPICall(gson) {
            directOrderAPI.directOrderInvoice(model)
        }
        return response
    }

    override suspend fun editDriverTruck(model: ReqAddDriverTruck, id: Int): Resource<AppResponse<Any>> {
        val response = makeAPICall(gson) {
            directOrderAPI.editDriverTruck(id, model)
        }
        return response
    }

    override suspend fun vehicleList(truckId: Int?): Resource<AppResponse<List<Vehicle>>> {
        val response = makeAPICall(gson) {
            directOrderAPI.vehicleList(truckId)
        }
        return response
    }

    override suspend fun driverList(): Resource<AppResponse<List<Driver>>> {
        val response = makeAPICall(gson) {
            directOrderAPI.driversList()
        }
        return response
    }

    override suspend fun tripStatus(): Resource<AppResponse<List<com.shahen.provider.core.models.responses.direct_order.trip_details.Data>>> {
        val response = makeAPICall(gson) {
            directOrderAPI.tripStatus()
        }
        return response
    }

    override suspend fun changeTripStatus(tripId: Int?, model: ReqChangeStatus): Resource<AppResponse<Any>> {
        val response = makeAPICall(gson) {
            directOrderAPI.changeTripStatus(tripId, model)
        }
        return response
    }

    override suspend fun orderStatus(model: ReqOrderStatus): Resource<AppResponse<List<com.shahen.provider.core.models.responses.direct_order.trip_details.Data>>> {
        val response = makeAPICall(gson) {
            directOrderAPI.orderStatus(model)
        }
        return response
    }

    override suspend fun changeOrderStatus(orderId: Int?, model: ReqChangeStatus): Resource<AppResponse<Any>> {
        val response = makeAPICall(gson) {
            directOrderAPI.changeOrderStatus(orderId, model)
        }
        return response
    }

    override suspend fun shipmentType(): Resource<AppResponse<RespShipmentType>> {
        val response = makeAPICall(gson) {
            directOrderAPI.shipmentType()
        }
        return response
    }

    override suspend fun goodsType(): Resource<AppResponse<RespGoodsType>> {
        val response = makeAPICall(gson) {
            directOrderAPI.goodsType()
        }
        return response
    }

    override suspend fun wayBillAndBayanDownload(tripId: Int, model: ReqWaybillAndBayan): Resource<AppResponse<RespWayBillAndBayanDownload>> {
        val response = makeAPICall(gson) {
            directOrderAPI.waybillAndBayanDownload(tripId, model)
        }
        return response
    }

    override suspend fun contractOrderList(model: ReqDirectOrderList): Resource<AppResponse<RespDirectOrderList>> {
        val response = makeAPICall(gson) {
            directOrderAPI.contractOrderList(model)
        }
        return response
    }*/
}