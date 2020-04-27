// DO NOT EDIT! This is an autogenerated file. All changes will be
// overwritten!

//	Copyright (c) 2016 Vidyo, Inc. All rights reserved.


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;
using System.Runtime.InteropServices;

namespace VidyoClient
{
	public class MediaConnectionTransportInfoFactory
	{
#if __IOS__
		const string importLib = "__Internal";
#else
		const string importLib = "libVidyoClient";
#endif
		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		public static extern IntPtr VidyoMediaConnectionTransportInfoConstructDefaultNative();
		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		public static extern void VidyoMediaConnectionTransportInfoDestructNative(IntPtr obj);
		public static MediaConnectionTransportInfo Create()
		{
			IntPtr objPtr = VidyoMediaConnectionTransportInfoConstructDefaultNative();
			return new MediaConnectionTransportInfo(objPtr);
		}
		public static void Destroy(MediaConnectionTransportInfo obj)
		{
			VidyoMediaConnectionTransportInfoDestructNative(obj.GetObjectPtr());
		}
	}
	public class MediaConnectionTransportInfo{
#if __IOS__
		const string importLib = "__Internal";
#else
		const string importLib = "libVidyoClient";
#endif
		private IntPtr objPtr; // opaque VidyoMediaConnectionTransportInfo reference.
		public IntPtr GetObjectPtr(){
			IntPtr nAddressType = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(addressType ?? string.Empty);
			IntPtr nComponentType = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(componentType ?? string.Empty);
			IntPtr nConnectionType = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(connectionType ?? string.Empty);
			IntPtr nExternalLocalAddr = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(externalLocalAddr ?? string.Empty);
			IntPtr nExternalRemoteAddr = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(externalRemoteAddr ?? string.Empty);
			IntPtr nInterfaceName = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(interfaceName ?? string.Empty);
			IntPtr nInterfaceType = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(interfaceType ?? string.Empty);
			IntPtr nInternalLocalAddr = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(internalLocalAddr ?? string.Empty);
			IntPtr nInternalRemoteAddr = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(internalRemoteAddr ?? string.Empty);
			IntPtr nTransportPlugIn = MarshalPtrToUtf8.GetInstance().MarshalManagedToNative(transportPlugIn ?? string.Empty);

			VidyoMediaConnectionTransportInfoSetaddressTypeNative(objPtr, nAddressType);
			VidyoMediaConnectionTransportInfoSetcomponentTypeNative(objPtr, nComponentType);
			VidyoMediaConnectionTransportInfoSetconnectionIdNative(objPtr, connectionId);
			VidyoMediaConnectionTransportInfoSetconnectionTypeNative(objPtr, nConnectionType);
			VidyoMediaConnectionTransportInfoSetexternalLocalAddrNative(objPtr, nExternalLocalAddr);
			VidyoMediaConnectionTransportInfoSetexternalRemoteAddrNative(objPtr, nExternalRemoteAddr);
			VidyoMediaConnectionTransportInfoSetinterfaceNameNative(objPtr, nInterfaceName);
			VidyoMediaConnectionTransportInfoSetinterfaceTypeNative(objPtr, nInterfaceType);
			VidyoMediaConnectionTransportInfoSetinternalLocalAddrNative(objPtr, nInternalLocalAddr);
			VidyoMediaConnectionTransportInfoSetinternalRemoteAddrNative(objPtr, nInternalRemoteAddr);
			VidyoMediaConnectionTransportInfoSettransportPlugInNative(objPtr, nTransportPlugIn);

			Marshal.FreeHGlobal(nTransportPlugIn);
			Marshal.FreeHGlobal(nInternalRemoteAddr);
			Marshal.FreeHGlobal(nInternalLocalAddr);
			Marshal.FreeHGlobal(nInterfaceType);
			Marshal.FreeHGlobal(nInterfaceName);
			Marshal.FreeHGlobal(nExternalRemoteAddr);
			Marshal.FreeHGlobal(nExternalLocalAddr);
			Marshal.FreeHGlobal(nConnectionType);
			Marshal.FreeHGlobal(nComponentType);
			Marshal.FreeHGlobal(nAddressType);
			return objPtr;
		}
		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoMediaConnectionTransportInfoGetaddressTypeNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoMediaConnectionTransportInfoSetaddressTypeNative(IntPtr obj, IntPtr addressType);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoMediaConnectionTransportInfoGetcomponentTypeNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoMediaConnectionTransportInfoSetcomponentTypeNative(IntPtr obj, IntPtr componentType);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern uint VidyoMediaConnectionTransportInfoGetconnectionIdNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoMediaConnectionTransportInfoSetconnectionIdNative(IntPtr obj, uint connectionId);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoMediaConnectionTransportInfoGetconnectionTypeNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoMediaConnectionTransportInfoSetconnectionTypeNative(IntPtr obj, IntPtr connectionType);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoMediaConnectionTransportInfoGetexternalLocalAddrNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoMediaConnectionTransportInfoSetexternalLocalAddrNative(IntPtr obj, IntPtr externalLocalAddr);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoMediaConnectionTransportInfoGetexternalRemoteAddrNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoMediaConnectionTransportInfoSetexternalRemoteAddrNative(IntPtr obj, IntPtr externalRemoteAddr);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoMediaConnectionTransportInfoGetinterfaceNameNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoMediaConnectionTransportInfoSetinterfaceNameNative(IntPtr obj, IntPtr interfaceName);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoMediaConnectionTransportInfoGetinterfaceTypeNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoMediaConnectionTransportInfoSetinterfaceTypeNative(IntPtr obj, IntPtr interfaceType);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoMediaConnectionTransportInfoGetinternalLocalAddrNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoMediaConnectionTransportInfoSetinternalLocalAddrNative(IntPtr obj, IntPtr internalLocalAddr);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoMediaConnectionTransportInfoGetinternalRemoteAddrNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoMediaConnectionTransportInfoSetinternalRemoteAddrNative(IntPtr obj, IntPtr internalRemoteAddr);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern IntPtr VidyoMediaConnectionTransportInfoGettransportPlugInNative(IntPtr obj);

		[DllImport(importLib, CallingConvention = CallingConvention.Cdecl)]
		private static extern void VidyoMediaConnectionTransportInfoSettransportPlugInNative(IntPtr obj, IntPtr transportPlugIn);

		public String addressType;
		public String componentType;
		public uint connectionId;
		public String connectionType;
		public String externalLocalAddr;
		public String externalRemoteAddr;
		public String interfaceName;
		public String interfaceType;
		public String internalLocalAddr;
		public String internalRemoteAddr;
		public String transportPlugIn;
		public MediaConnectionTransportInfo(IntPtr obj){
			objPtr = obj;

			addressType = (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(VidyoMediaConnectionTransportInfoGetaddressTypeNative(objPtr));
			componentType = (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(VidyoMediaConnectionTransportInfoGetcomponentTypeNative(objPtr));
			connectionId = VidyoMediaConnectionTransportInfoGetconnectionIdNative(objPtr);
			connectionType = (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(VidyoMediaConnectionTransportInfoGetconnectionTypeNative(objPtr));
			externalLocalAddr = (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(VidyoMediaConnectionTransportInfoGetexternalLocalAddrNative(objPtr));
			externalRemoteAddr = (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(VidyoMediaConnectionTransportInfoGetexternalRemoteAddrNative(objPtr));
			interfaceName = (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(VidyoMediaConnectionTransportInfoGetinterfaceNameNative(objPtr));
			interfaceType = (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(VidyoMediaConnectionTransportInfoGetinterfaceTypeNative(objPtr));
			internalLocalAddr = (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(VidyoMediaConnectionTransportInfoGetinternalLocalAddrNative(objPtr));
			internalRemoteAddr = (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(VidyoMediaConnectionTransportInfoGetinternalRemoteAddrNative(objPtr));
			transportPlugIn = (string)MarshalPtrToUtf8.GetInstance().MarshalNativeToManaged(VidyoMediaConnectionTransportInfoGettransportPlugInNative(objPtr));
		}
	};
}
